package com.alura.easycharge.controller;

import com.alura.easycharge.dto.ClienteDTO;
import com.alura.easycharge.dto.ClienteDTOJson;
import com.alura.easycharge.form.ClienteForm;
import com.alura.easycharge.mapper.ClienteMapper;
import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.projection.ClienteRelatorioProjection;
import com.alura.easycharge.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
      public  Page<ClienteDTOJson> lista(@PageableDefault(sort = "id", direction = Sort.Direction.DESC,page = 0, size = 10) Pageable paginacao){
        Page<Cliente> clientes = clienteRepository.findAll(paginacao);
        return ClienteDTOJson.converter(clientes);
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "relatorioCliente", allEntries = true)
    public ResponseEntity<ClienteDTOJson> cadastrar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder){
        Cliente cliente = new ClienteMapper().cadastrar(form);
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/api/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDTOJson(cliente));
    }

    @GetMapping("/{id}")
    public ClienteDTO detalhar(@PathVariable Long id){
        Cliente cliente = clienteRepository.getById(id);
        return new ClienteDTO(cliente);
    }

    @GetMapping("/report")
    @Cacheable(value = "relatorioCliente")
    public List<ClienteRelatorioProjection> relatorio(){
        return clienteRepository.findTotalDividasCobrancasPorNome();
    }
}
