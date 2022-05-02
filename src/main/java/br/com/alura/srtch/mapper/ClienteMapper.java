package br.com.alura.srtch.mapper;

import br.com.alura.srtch.dto.ClienteDTO;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.Endereco;

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
}
