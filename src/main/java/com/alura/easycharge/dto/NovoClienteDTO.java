package com.alura.easycharge.dto;

import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.models.Endereco;
import com.alura.easycharge.models.StatusCliente;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class NovoClienteDTO {

    Endereco endereco = new Endereco();

    private String nomeCliente;

    private String cpfCliente;

    private String telefoneCliente;

    private String local = endereco.getCidade() + "/" + endereco.getEstado();

    private BigDecimal rendaCliente;

    private StatusCliente statusCliente;

    public NovoClienteDTO() {
    }

    public NovoClienteDTO(Cliente cliente) {
        this.nomeCliente = cliente.getNome();
        this.cpfCliente = cliente.getCpf();
        this.telefoneCliente = cliente.getTelefone();
        this.local = cliente.getEndereco().getCidade() + "/" + cliente.getEndereco().getEstado();
        this.rendaCliente = cliente.getRenda();
        this.statusCliente = cliente.getStatus();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public String getLocal() {
        return local;
    }

    public BigDecimal getRendaCliente() {
        return rendaCliente;
    }

    public StatusCliente getStatusCliente() {
        return statusCliente;
    }

    public static List<NovoClienteDTO> converter(List<Cliente> clientes){
        return clientes.stream().map(NovoClienteDTO::new).collect(Collectors.toList());
    }
}
