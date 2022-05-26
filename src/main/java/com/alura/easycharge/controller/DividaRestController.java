package com.alura.easycharge.controller;

import com.alura.easycharge.dto.ClienteDTOJson;
import com.alura.easycharge.dto.CobrancaDTO;
import com.alura.easycharge.dto.DividaDTO;
import com.alura.easycharge.form.ClienteForm;
import com.alura.easycharge.form.DividaForm;
import com.alura.easycharge.mapper.DividaMapper;
import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.models.Cobranca;
import com.alura.easycharge.models.Divida;
import com.alura.easycharge.repository.ClienteRepository;
import com.alura.easycharge.repository.DividaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/dividas")
public class DividaRestController {

    @Autowired
    private DividaRepository dividaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<DividaDTO> lista(){
        List<Divida> dividas = dividaRepository.findAll();
        return DividaDTO.converter(dividas);
    }

    @PostMapping
    public ResponseEntity<DividaDTO> cadastrar(@RequestBody @Valid DividaForm dividaForm, UriComponentsBuilder uriBuilder){
        Divida divida = new DividaMapper().cadastrar(dividaForm,clienteRepository);
        dividaRepository.save(divida);

        URI uri = uriBuilder.path("/api/dividas/{id}").buildAndExpand(divida.getCliente().getId()).toUri();
        return ResponseEntity.created(uri).body(new DividaDTO(divida));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DividaDTO> atualizar(@PathVariable Long id, @RequestBody @Valid DividaForm form){
        Cliente cliente = clienteRepository.findById(form.getIdCliente())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "O cliente " + form.getIdCliente() + " não existe"));
        Divida divida = form.atualizar(id,cliente, dividaRepository);
        return ResponseEntity.ok(new DividaDTO(divida));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable Long id){
        dividaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public DividaDTO detalhar(@PathVariable Long id){
        Divida divida = dividaRepository.getById(id);
        return new DividaDTO(divida);
    }
}
