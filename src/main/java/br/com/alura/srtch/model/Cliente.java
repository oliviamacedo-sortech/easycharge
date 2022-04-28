package br.com.alura.srtch.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente  {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private StatusCliente status;

  @OneToOne
  private Endereco endereco;

  private String nome;

  private String cpf;

  private String telefone;

  private String email;

  private String profissao;

  private BigDecimal renda;

  public Cliente() {
  }

  public Cliente(StatusCliente status, Endereco endereco, String nome, String cpf, String telefone, String email, String profissao, BigDecimal renda) {
    this.status = status;
    this.endereco = endereco;
    this.nome = nome;
    this.cpf = cpf;
    this.telefone = telefone;
    this.email = email;
    this.profissao = profissao;
    this.renda = renda;
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
}
