package com.alura.easycharge.controller;

import com.alura.easycharge.dto.ClienteDTO;
import com.alura.easycharge.dto.ClienteForm;
import com.alura.easycharge.mapper.ClienteMapper;
import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControllerRest {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<ClienteForm> lista(){
        List<Cliente> clientes = clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome").and(Sort.by(Sort.Direction.ASC,"status")));
        return ClienteForm.converter(clientes);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> cadastrar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder){
        Cliente cliente = new ClienteMapper().cadastrar(form);
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/api/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
    }
}
