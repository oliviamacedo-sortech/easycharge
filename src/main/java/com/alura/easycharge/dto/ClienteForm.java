package com.alura.easycharge.dto;

import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.models.Endereco;
import com.alura.easycharge.models.StatusCliente;
import com.alura.easycharge.repository.ClienteRepository;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteForm {

    @NotBlank(message = "É preciso preencher o Nome!")
    private String nome;

    @NotBlank
    private String cpf;

    @NotBlank
    private String telefone;

    @NotBlank
    private String rua;

    @NotBlank
    private String numero;

    @NotBlank
    private String complemento;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    @NotNull
    @Positive
    private BigDecimal renda;

    private StatusCliente status;

    public ClienteForm() {
    }

    public ClienteForm(Cliente cliente) {
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getTelefone();
        this.rua = cliente.getEndereco().getRua();
        this.numero = cliente.getEndereco().getNumero();
        this.complemento = cliente.getEndereco().getComplemento();
        this.bairro = cliente.getEndereco().getBairro();
        this.cidade = cliente.getEndereco().getCidade();
        this.estado = cliente.getEndereco().getEstado();
        this.renda = cliente.getRenda();
        this.status = cliente.getStatus();
    }


    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public StatusCliente getStatus() {
        return status;
    }

    public static List<ClienteForm> converter(List<Cliente> clientes){
        return clientes.stream().map(ClienteForm::new).collect(Collectors.toList());
    }

}
