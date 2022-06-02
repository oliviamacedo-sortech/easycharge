package com.alura.easycharge.dto;

import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.models.Endereco;
import com.alura.easycharge.models.StatusCliente;
import org.springframework.data.domain.Page;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class ClienteDTO {

    private Long id;

    @NotBlank(message = "É preciso preencher o Nome!")
    private String nome;

    @NotBlank(message = "É preciso preencher o CPF!")
    private String cpf;

    @NotBlank(message = "É preciso preencher o Email!")
    @Email
    private String email;

    @NotBlank(message = "É preciso preencher o Telefone!")
    private String telefone;

    @NotBlank(message = "É preciso preencher a Rua!")
    private String rua;

    @NotBlank(message = "É preciso preencher o Número!")
    private String numero;

    private String complemento;

    @NotBlank(message = "É preciso preencher o Bairro!")
    private String bairro;

    @NotBlank(message = "É preciso preencher a Cidade!")
    private String cidade;

    @NotBlank(message = "É preciso preencher o Estado!")
    private String estado;

    @NotBlank(message = "É preciso preencher a Profissão!")
    private String profissao;

    @NotNull
    @Positive
    private BigDecimal renda;

    @NotNull
    private StatusCliente status = StatusCliente.ATIVO;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.rua = cliente.getEndereco().getRua();
        this.numero = cliente.getEndereco().getNumero();
        this.complemento = cliente.getEndereco().getComplemento();
        this.bairro = cliente.getEndereco().getBairro();
        this.cidade = cliente.getEndereco().getCidade();
        this.estado = cliente.getEndereco().getEstado();
        this.profissao = cliente.getProfissao();
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

    public String getProfissao() {
        return profissao;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public StatusCliente getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public void setStatus(StatusCliente status) {
        this.status = status;
    }

    public Cliente toCliente() {
        Cliente cliente = new Cliente();
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

    public void toDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.rua = cliente.getEndereco().getRua();
        this.numero = cliente.getEndereco().getNumero();
        this.complemento = cliente.getEndereco().getComplemento();
        this.bairro = cliente.getEndereco().getBairro();
        this.cidade = cliente.getEndereco().getCidade();
        this.estado = cliente.getEndereco().getEstado();
        this.profissao = cliente.getProfissao();
        this.renda = cliente.getRenda();
        this.status = cliente.getStatus();
    }

    public static Page<ClienteDTO> converter(Page<Cliente> clientes){
        return clientes.map(ClienteDTO::new);
    }
}
