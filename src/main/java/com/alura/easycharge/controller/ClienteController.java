package com.alura.easycharge.controller;

import com.alura.easycharge.dto.ClienteDTO;
import com.alura.easycharge.mapper.ClienteMapper;
import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/listaCliente")
    public String lista(Model model){
        List<Cliente> clientes = clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome").and(Sort.by(Sort.Direction.ASC,"status")));
        model.addAttribute("clientes", clientes);
        return "listaCliente";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id){
        clienteRepository.deleteById(id);
        return "redirect:/listaCliente";
    }


    @Transactional
    @GetMapping("/alterarStatus")
    public String alterarStatus(@RequestParam Long id){
        Cliente cliente = clienteRepository.getById(id);
        cliente.alteracaoStatus(cliente);
        return "redirect:/listaCliente";
    }

    @GetMapping("/editar")
    public String atualizar(Model model, Long id) {
        Cliente cliente = clienteRepository.getById(id);
        model.addAttribute("cliente", cliente);
        return "cliente/alterarCliente";
    }

    @Transactional
    @PostMapping("/cliente/alterarCliente")
    public String atualizar(@Valid ClienteDTO dto, BindingResult result){
        if (result.hasErrors()){
            return "cliente/formulario";
       }
        Cliente cliente = clienteRepository.getById(dto.getId());
        ClienteMapper map = new ClienteMapper();
        map.alterar(cliente,dto);
        return "redirect:/listaCliente";
    }

}
