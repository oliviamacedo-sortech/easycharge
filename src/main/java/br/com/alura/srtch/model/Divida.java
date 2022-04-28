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

    @Column(nullable = false, name = "valor_divida")
    private BigDecimal valorDivida;

    @Column(name = "data_abertura")
    private Date dataAbertura;

    @Column(name = "data_quitacao")
    private Date dataQuitacao;

    @Column(nullable = false, name = "status_divida")
    @Enumerated(EnumType.STRING)
    private StatusDivida statusDivida;

    @Column(length=255, name = "descricao_quitacao")
    private String descricaoQuitacao;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cliente cliente;

    public Divida() {
    }

    public Divida(BigDecimal valorDivida, StatusDivida statusDivida, Cliente cliente) {
        this.valorDivida = valorDivida;
        this.statusDivida = statusDivida;
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

    @Override
    public String toString() {
        return "Divida{" +
                "valorDivida=" + valorDivida +
                ", dataAbertura=" + dataAbertura +
                ", dataQuitacao=" + dataQuitacao +
                ", statusDivida=" + statusDivida +
                ", descricaoQuitacao='" + descricaoQuitacao + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
