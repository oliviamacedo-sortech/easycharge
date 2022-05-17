package com.alura.easycharge.mapper;


import com.alura.easycharge.dto.ClienteDTO;
import com.alura.easycharge.form.ClienteForm;
import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.models.Endereco;

import java.util.ArrayList;
import java.util.List;

public class ClienteMapper {

    public static List<Cliente> passarParaCliente(List<ClienteDTO> clienteDTO) {
        List<Cliente> clientes = new ArrayList<>();
        for (ClienteDTO dto : clienteDTO) {
            Cliente cliente = new Cliente();
            cliente.setCpf(dto.getCpf());
            cliente.setEmail(dto.getEmail());
            cliente.setNome(dto.getNome());
            cliente.setProfissao(dto.getProfissao());
            cliente.setRenda(dto.getRenda());
            cliente.setTelefone(dto.getTelefone());
            cliente.setStatus(dto.getStatus());
            cliente.setEndereco(new Endereco(dto.getRua(), dto.getNumero(), dto.getComplemento(), dto.getBairro(), dto.getCidade(), dto.getEstado()));
            clientes.add(cliente);
        }
        return clientes;
    }

    public Cliente alterar(Cliente cliente, ClienteDTO dto){
        cliente.setCpf(dto.getCpf());
        cliente.setEmail(dto.getEmail());
        cliente.setNome(dto.getNome());
        cliente.setProfissao(dto.getProfissao());
        cliente.setRenda(dto.getRenda());
        cliente.setTelefone(dto.getTelefone());
        cliente.setStatus(dto.getStatus());
        cliente.setEndereco(new Endereco(dto.getRua(), dto.getNumero(), dto.getComplemento(), dto.getBairro(), dto.getCidade(), dto.getEstado()));
        return cliente;
    }

//    public Cliente cadastrar(ClienteForm form){
//        Endereco endereco;
//        endereco = new Endereco(form.getRua(), form.getNumero(), form.getComplemento(), form.getBairro(), form.getCidade(), form.getEstado());
//
//        return new Cliente(form.getNome(), form.getCpf(), form.getEmail(), form.getTelefone(), endereco, form.getProfissao(), form.getRenda(),form.getStatus());
//    }
}
