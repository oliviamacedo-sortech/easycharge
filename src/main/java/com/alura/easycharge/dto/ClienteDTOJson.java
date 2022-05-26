package com.alura.easycharge.dto;

import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.models.Endereco;
import com.alura.easycharge.models.StatusCliente;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

public class ClienteDTOJson {

    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    private String local;

    private BigDecimal renda;

    private StatusCliente status;

    public ClienteDTOJson() {
    }

    public ClienteDTOJson(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.local = cliente.getEndereco().getCidade() + "/" + cliente.getEndereco().getEstado();
        this.renda = cliente.getRenda();
        this.status = cliente.getStatus();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getLocal() {
        return local;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public StatusCliente getStatus() {
        return status;
    }

    public Cliente toCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setRenda(renda);
        cliente.setStatus(status);

        return cliente;
    }

    public static Page<ClienteDTOJson> converter(Page<Cliente> clientes){
        return clientes.map(ClienteDTOJson::new);
    }
}
