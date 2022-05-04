package com.alura.easycharge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("cliente")
public class ClienteController {

    @GetMapping("formulario")
    public String formulario(){
        return "cliente/formulario";
    }
}
