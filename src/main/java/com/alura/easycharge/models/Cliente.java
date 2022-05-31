package com.alura.easycharge.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "clientes")
public class Cliente  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    private String profissao;

    private BigDecimal renda;

    @Enumerated(EnumType.STRING)
    private StatusCliente status;

    public Cliente() {
    }

    public Cliente(Long id){
        this.id = id;
    }

    public Cliente(String nome, String cpf, String email, String telefone, Endereco endereco, String profissao, BigDecimal renda, StatusCliente status) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.profissao = profissao;
        this.renda = renda;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public StatusCliente getStatus() {
        return status;
    }

    public void setStatus(StatusCliente status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", rua='" + endereco.getRua() + '\'' +
                ", numero='" + endereco.getNumero() + '\'' +
                ", complemento='" + endereco.getComplemento() + '\'' +
                ", bairro='" + endereco.getBairro() + '\'' +
                ", cidade='" + endereco.getCidade() + '\'' +
                ", estado='" + endereco.getEstado() + '\'' +
                ", profissao='" + profissao + '\'' +
                ", renda=" + renda +
                ", status=" + status +
                '}';
    }

    public Cliente alteracaoStatus(Cliente cliente){
        if (cliente.getStatus().equals(StatusCliente.ATIVO)){
            cliente.setStatus(StatusCliente.SUSPENSO);
        } else {
            cliente.setStatus(StatusCliente.ATIVO);
        }
        return cliente;
    }
}
