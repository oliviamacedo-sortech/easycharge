package com.alura.easycharge.controller;

import com.alura.easycharge.repository.DividaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes/divida")
public class DividaRestController {

    @Autowired
    DividaRepository dividaRepository;

    
}
