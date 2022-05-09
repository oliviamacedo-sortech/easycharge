package com.alura.easycharge.controller;

import com.alura.easycharge.dto.ClienteDTO;
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
public class NovoClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("formulario")
    public String formulario(ClienteDTO requisicao){
        return "cliente/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid ClienteDTO requisicao, BindingResult result){
        if (result.hasErrors()){
            return "cliente/formulario";
        }
        Cliente cliente = requisicao.toCliente();
        clienteRepository.save(cliente);
        return "redirect:/listaCliente";
    }


}
