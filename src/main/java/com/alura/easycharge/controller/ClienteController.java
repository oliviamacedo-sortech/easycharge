package com.alura.easycharge.controller;

import com.alura.easycharge.models.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Controller
public class ClienteController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/listaCliente")
    public String lista(Model model){

        Query query = entityManager.createQuery("select c from Cliente c", Cliente.class);
        List<Cliente> clientes = query.getResultList();

        model.addAttribute("clientes", clientes);
        return "listaCliente";
    }
}
