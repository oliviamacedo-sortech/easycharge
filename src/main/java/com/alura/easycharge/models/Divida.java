package com.alura.easycharge.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "dividas")
public class Divida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "valor_divida")
    private BigDecimal valor;

    @Column(name = "data_abertura")
    private LocalDate dataAbertura = LocalDate.now();

    @Column(name = "data_quitacao")
    private LocalDate dataQuitacao;

    @Column(nullable = false, name = "status_divida")
    @Enumerated(EnumType.STRING)
    private StatusDivida statusDivida = StatusDivida.ABERTA;

    @Column(length=255, name = "descricao_quitacao")
    private String descricaoQuitacao;


    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "divida", cascade = CascadeType.ALL)
    private final List<Cobranca> cobrancas = new ArrayList<>();

    public Divida() {
    }

    public Divida(BigDecimal valor, LocalDate dataAbertura, LocalDate dataQuitacao, StatusDivida statusDivida, String descricaoQuitacao, Cliente cliente) {
        this.valor = valor;
        this.dataAbertura = dataAbertura;
        this.dataQuitacao = dataQuitacao;
        this.statusDivida = statusDivida;
        this.descricaoQuitacao = descricaoQuitacao;
        this.cliente = cliente;
    }


    public void adicionarCobranca(Cobranca cobranca){
        cobranca.setDivida(this);
        this.cobrancas.add(cobranca);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataQuitacao() {
        return dataQuitacao;
    }

    public void setDataQuitacao(LocalDate dataQuitacao) {
        this.dataQuitacao = dataQuitacao;
    }

    public StatusDivida getStatusDivida() {
        return statusDivida;
    }

    public void setStatusDivida(StatusDivida statusDivida) {
        this.statusDivida = statusDivida;
    }

    public String getDescricaoQuitacao() {
        return descricaoQuitacao;
    }

    public void setDescricaoQuitacao(String descricaoQuitacao) {
        this.descricaoQuitacao = descricaoQuitacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Divida{" +
                "valorDivida=" + valor +
                ", dataAbertura=" + dataAbertura +
                ", dataQuitacao=" + dataQuitacao +
                ", statusDivida=" + statusDivida +
                ", descricaoQuitacao='" + descricaoQuitacao + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
