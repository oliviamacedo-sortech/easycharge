package br.com.alura.srtch.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name= "dividas")
public class Divida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal valorDivida;


    private Date dataAbertura;

    private Date dataQuitacao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusDivida statusDivida;

    @Column(length=255)
    private String descricaoQuitacao;

    @OneToMany
    private Cliente cliente;

    public Divida() {
    }

    public Divida(BigDecimal valorDivida, Date dataAbertura, Date dataQuitacao, StatusDivida statusDivida, String descricaoQuitacao, Cliente cliente) {
        this.valorDivida = valorDivida;
        this.dataAbertura = dataAbertura;
        this.dataQuitacao = dataQuitacao;
        this.statusDivida = statusDivida;
        this.descricaoQuitacao = descricaoQuitacao;
        this.cliente = cliente;
    }

    public BigDecimal getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(BigDecimal valorDivida) {
        this.valorDivida = valorDivida;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataQuitacao() {
        return dataQuitacao;
    }

    public void setDataQuitacao(Date dataQuitacao) {
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
}
