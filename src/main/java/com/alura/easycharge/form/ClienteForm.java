package com.alura.easycharge.form;

import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.models.Endereco;
import com.alura.easycharge.models.StatusCliente;
import com.alura.easycharge.repository.ClienteRepository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class ClienteForm {

    @NotBlank(message = "É preciso preencher o Nome!")
    private String nome;

    @NotBlank
    private String cpf;

    @NotBlank @Email
    private String email;

    @NotBlank
    private String telefone;

    @NotBlank
    private String rua;

    @NotBlank
    private String numero;

    private String complemento;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    @NotBlank
    private String profissao;

    @NotNull
    @Positive
    private BigDecimal renda;

    @NotNull
    private StatusCliente status = StatusCliente.ATIVO;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public StatusCliente getStatus() {
        return status;
    }

    public void setStatus(StatusCliente status) {
        this.status = status;
    }

    public Cliente atualizar(Long id, ClienteRepository clienteRepository) {
        Cliente cliente = clienteRepository.getById(id);
        cliente.setNome(this.nome);
        cliente.setCpf(this.cpf);
        cliente.setEmail(this.email);
        cliente.setTelefone(this.telefone);
        cliente.setRenda(this.renda);
        cliente.setStatus(this.status);
        cliente.setProfissao(this.profissao);
        cliente.setEndereco(new Endereco(this.rua, this.numero, this.complemento, this.bairro, this.cidade, this.estado));
        return cliente;
    }
}
