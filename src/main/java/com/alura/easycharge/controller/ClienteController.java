package com.alura.easycharge.controller;

import com.alura.easycharge.dto.RequisicaoNovoCliente;
import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("formulario")
    public String formulario(){
        return "cliente/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoCliente requisicao, BindingResult result){
        if (result.hasErrors()){
            return "pedido/formulario";
        }

        Cliente cliente = requisicao.toCliente();
        clienteRepository.save(cliente);
        return "cliente/formulario";
    }
}
