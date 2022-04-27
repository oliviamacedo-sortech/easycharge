package br.com.alura.srtch.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvRecurse;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "clientes")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  @CsvBindByName
  @Enumerated(EnumType.STRING)
  private StatusCliente status;

  @OneToOne
  @CsvRecurse
  private Endereco endereco;

  @CsvBindByName
  private String nome;

  @CsvBindByName
  private String cpf;

  @CsvBindByName
  private String telefone;

  @CsvBindByName
  private String email;

  @CsvBindByName
  private String profissao;

  @CsvBindByName
  private BigDecimal renda;

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
