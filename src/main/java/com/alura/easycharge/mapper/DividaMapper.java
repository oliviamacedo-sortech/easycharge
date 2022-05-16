package com.alura.easycharge.mapper;

import com.alura.easycharge.form.DividaForm;
import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.models.Divida;
import com.alura.easycharge.repository.ClienteRepository;

public class DividaMapper {
    public Divida cadastrar(DividaForm dividaForm, ClienteRepository clienteRepository){
        Cliente cliente = clienteRepository.getById(dividaForm.getIdCliente());

        return new Divida(dividaForm.getValor(),dividaForm.getDataAbertura(),dividaForm.getDataQuitacao(),dividaForm.getStatusDivida(), dividaForm.getDescricaoQuitacao(), cliente);
    }
}
