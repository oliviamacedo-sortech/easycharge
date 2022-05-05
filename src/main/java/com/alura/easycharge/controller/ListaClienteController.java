package com.alura.easycharge.controller;

import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.models.StatusCliente;
import com.alura.easycharge.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/delete")
    public String delete(@RequestParam Long id){
//        Cliente cliente = clienteRepository.getById(id);
        clienteRepository.deleteById(id);
        return "redirect:/listaCliente";
    }

    @GetMapping("/alterar")
    public String alterar(@RequestParam Long id){
        Cliente cliente = clienteRepository.getById(id);
        if (cliente.getStatus().equals(StatusCliente.ATIVO)){
            cliente.setStatus(StatusCliente.SUSPENSO);
        } else {
            cliente.setStatus(StatusCliente.ATIVO);
        }
        clienteRepository.save(cliente);
        return "redirect:/listaCliente";
    }
    
}
