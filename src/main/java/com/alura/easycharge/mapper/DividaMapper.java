package com.alura.easycharge.mapper;

import com.alura.easycharge.form.DividaForm;
import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.models.Divida;
import com.alura.easycharge.repository.ClienteRepository;

public class DividaMapper {
    public Divida cadastrar(DividaForm form){
        Cliente cliente = new Cliente(form.idCliente());
        Divida divida = new Divida();
        divida.setValor(form.getValor());
        divida.setDataAbertura(form.getDataAbertura());
        divida.setDataQuitacao(form.getDataQuitacao());
        divida.setStatusDivida(form.getStatusDivida());
        divida.setDescricaoQuitacao(form.getDescricaoQuitacao());
        divida.setCliente(cliente);
        return divida;
    }
}
