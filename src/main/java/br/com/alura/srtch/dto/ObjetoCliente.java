package br.com.alura.srtch.dto;

import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.Endereco;

import java.util.ArrayList;
import java.util.List;

public class ObjetoCliente {

        public List<Cliente> passarParaCliente(List<ClienteDTO> clienteDTOS){
            List<Cliente> clientes = new ArrayList<>();
            Endereco endereco = new Endereco();
            for (ClienteDTO cDTO : clienteDTOS){
                endereco.setBairro(cDTO.getBairro());
                endereco.setCidade(cDTO.getCidade());
                endereco.setComplemento(cDTO.getComplemento());
                endereco.setEstado(cDTO.getEstado());
                endereco.setRua(cDTO.getRua());

//                endereco = new Endereco(cDTO.getRua(),cDTO.getNumero(),cDTO.getComplemento(),cDTO.getBairro(),cDTO.getCidade(),cDTO.getEstado());
                clientes.add(new Cliente(cDTO.getStatus(),endereco,cDTO.getNome(),cDTO.getCpf(),cDTO.getTelefone(),cDTO.getEmail(),cDTO.getProfissao(),cDTO.getRenda()));

                if(cDTO.getComplemento() != null){
                    endereco.setComplemento(cDTO.getComplemento());
                }
            }
            return clientes;
        }
}
