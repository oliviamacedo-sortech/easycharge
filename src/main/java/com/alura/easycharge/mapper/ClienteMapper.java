package com.alura.easycharge.mapper;


import com.alura.easycharge.dto.ClienteDTO;
import com.alura.easycharge.dto.ClienteForm;
import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.models.Endereco;

import java.util.ArrayList;
import java.util.List;

public class ClienteMapper {

    public static List<Cliente> passarParaCliente(List<ClienteDTO> clienteDTO) {
        List<Cliente> clientes = new ArrayList<>();
        for (ClienteDTO dto : clienteDTO) {
            Cliente cliente = new Cliente();
            cliente.setCpf(dto.getCpfCliente());
            cliente.setEmail(dto.getEmailCliente());
            cliente.setNome(dto.getNomeCliente());
            cliente.setProfissao(dto.getProfissaoCliente());
            cliente.setRenda(dto.getRendaCliente());
            cliente.setTelefone(dto.getTelefoneCliente());
            cliente.setStatus(dto.getStatusCliente());
            cliente.setEndereco(new Endereco(dto.getRuaEnderecoCliente(), dto.getNumeroEnderecoCliente(), dto.getComplementoEnderecoCliente(), dto.getBairroEnderecoCliente(), dto.getCidadeEnderecoCliente(), dto.getEstadoEnderecoCliente()));
            clientes.add(cliente);
        }
        return clientes;
    }

    public Cliente alterar(Cliente cliente, ClienteDTO dto){
        cliente.setCpf(dto.getCpfCliente());
        cliente.setEmail(dto.getEmailCliente());
        cliente.setNome(dto.getNomeCliente());
        cliente.setProfissao(dto.getProfissaoCliente());
        cliente.setRenda(dto.getRendaCliente());
        cliente.setTelefone(dto.getTelefoneCliente());
        cliente.setStatus(dto.getStatusCliente());
        cliente.setEndereco(new Endereco(dto.getRuaEnderecoCliente(), dto.getNumeroEnderecoCliente(), dto.getComplementoEnderecoCliente(), dto.getBairroEnderecoCliente(), dto.getCidadeEnderecoCliente(), dto.getEstadoEnderecoCliente()));
        return cliente;
    }

    public Cliente cadastrar(ClienteForm form){
        Endereco endereco;
        endereco = new Endereco(form.getRua(), form.getNumero(), form.getComplemento(), form.getBairro(), form.getCidade(), form.getEstado());

        return new Cliente( form.getStatus(), endereco, form.getCpf(), form.getNome(), form.getTelefone(),form.getRenda());
    }
}
