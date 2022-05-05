package com.alura.easycharge.controller;

import com.alura.easycharge.dto.ClienteDTO;
import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.models.StatusCliente;
import com.alura.easycharge.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ListaClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/listaCliente")
    public String lista(Model model){

        List<Cliente> clientes = clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "status").and(Sort.by(Sort.Direction.ASC,"nome")));
        model.addAttribute("clientes", clientes);
        return "listaCliente";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id){
//        Cliente cliente = clienteRepository.getById(id);
        clienteRepository.deleteById(id);
        return "redirect:/listaCliente";
    }

    @GetMapping("/alterarStatus")
    public String alterarStatus(@RequestParam Long id){
        Cliente cliente = clienteRepository.getById(id);
        if (cliente.getStatus().equals(StatusCliente.ATIVO)){
            cliente.setStatus(StatusCliente.SUSPENSO);
        } else {
            cliente.setStatus(StatusCliente.ATIVO);
        }
        clienteRepository.save(cliente);
        return "redirect:/listaCliente";
    }

    @GetMapping("/editar")
    public String getEditForm(Model model, Long id) {
        Cliente cliente = clienteRepository.getById(id);
        model.addAttribute("cliente", cliente);
        return "redirect:cliente/formulario";
    }

    // request mapping method to submit edited details
    @PostMapping("/editar")
    public String submitForm(@ModelAttribute Cliente cliente, Model model) {
        model.addAttribute("cliente", cliente);
        return "redirect:/listaCliente";
    }

//    @GetMapping("/editar")
//    public ModelAndView editar(@RequestParam Long id, ClienteDTO requisicao, BindingResult result)  {
//        Cliente cliente = clienteRepository.getById(id);
//
//        ModelAndView mav = new ModelAndView("cliente/formulario");
//        if (result.hasErrors()) {
//            mav.setViewName("editar");
//            mav.addObject("cliente", requisicao);
//
//            return mav;
//        }
//
//        clienteRepository.save(cliente);
//
//        mav.setViewName("redirect:cliente/formulario");
//
//        return mav;
//
//
//
//    }
//        Cliente cliente = requisicao.toCliente();
//        clienteRepository.findById(id).get();
//        ModelAndView mav = new ModelAndView("cliente/formulario");
//        mav.addObject("cliente", cliente);
//        return mav;


//    public String novo(@Valid ClienteDTO requisicao, BindingResult result){
//        if (result.hasErrors()){
//            return "cliente/formulario";
//        }
//        Cliente cliente = requisicao.toCliente();
//        clienteRepository.save(cliente);
//        return "redirect:/listaCliente";
//    }
}
