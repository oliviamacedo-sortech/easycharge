package com.alura.easycharge.controller;

import com.alura.easycharge.dto.ClienteDTO;
import com.alura.easycharge.form.ClienteForm;
import com.alura.easycharge.mapper.ClienteMapper;
import com.alura.easycharge.models.Cliente;
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

@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    @Cacheable(value = "listaDeClientes")
//    public Page<ClienteForm> lista(@RequestParam int pagina,@RequestParam int qtd, @RequestParam String ordenacao){
//        Pageable paginacao = PageRequest.of(pagina,qtd, Sort.Direction.ASC, ordenacao);
      public  Page<ClienteDTO> lista(@PageableDefault(sort = "id", direction = Sort.Direction.DESC,page = 0, size = 10) Pageable paginacao){
        Page<Cliente> clientes = clienteRepository.findAll(paginacao);
        return ClienteDTO.converter(clientes);
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaDeClientes", allEntries = true)
    public ResponseEntity<ClienteForm> cadastrar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder){
        Cliente cliente = new ClienteForm().cadastrar(form);
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/api/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteForm(cliente));
    }

    @GetMapping("/{id}")
    public ClienteDTO detalhar(@PathVariable Long id){
        Cliente cliente = clienteRepository.getById(id);
        return new ClienteDTO(cliente);
    }
}
