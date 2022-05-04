package com.alura.easycharge.controller;

import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ListaClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/listaCliente")
    public String lista(Model model){

        List<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        return "listaCliente";
    }


}
