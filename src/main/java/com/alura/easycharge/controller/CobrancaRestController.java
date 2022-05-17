package com.alura.easycharge.controller;

import com.alura.easycharge.dto.ClienteDTOJson;
import com.alura.easycharge.dto.CobrancaDTO;
import com.alura.easycharge.form.ClienteForm;
import com.alura.easycharge.form.CobrancaForm;
import com.alura.easycharge.mapper.ClienteMapper;
import com.alura.easycharge.mapper.CobrancaMapper;
import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.models.Cobranca;
import com.alura.easycharge.repository.CobrancaRepository;
import com.alura.easycharge.repository.DividaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/cobrancas")
public class CobrancaRestController {

    @Autowired
    private CobrancaRepository cobrancaRepository;

    @Autowired
    private DividaRepository dividaRepository;

    @PostMapping
    public ResponseEntity<CobrancaDTO> cadastrar(@RequestBody @Valid CobrancaForm form, UriComponentsBuilder uriBuilder){
        Cobranca cobranca = new CobrancaMapper().cadastrar(form,dividaRepository);
        cobrancaRepository.save(cobranca);

        URI uri = uriBuilder.path("/api/clientes/{id}").buildAndExpand(cobranca.getId()).toUri();
        return ResponseEntity.created(uri).body(new CobrancaDTO(cobranca));
    }
}
