package com.alura.easycharge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ClienteController {

    @GetMapping("/listaCliente")
    public String lista(HttpServletRequest request){
        request.setAttribute("nome", "Mundo");
        return "listaCliente";
    }
}
