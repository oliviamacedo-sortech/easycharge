package com.alura.easycharge.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "cobrancas")
public class Cobranca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "data_realizacao")
    private LocalDate dataRealizacao;

    @Column(nullable = false, name = "meio_de_contato")
    @Enumerated(EnumType.STRING)
    private MeioContato meioContato;

    @Column(nullable = false)
    private String agente;

    @Column(nullable = false, name = "tipo_agente")
    @Enumerated(EnumType.STRING)
    private TipoAgente tipoAgente;

    @Column(nullable = false, length = 500, name = "comentario_agente")
    private String comentarioAgente;

    @Column(length = 500)
    private String acordo;

    @Column(nullable = false, name = "tipo_acordo")
    @Enumerated(EnumType.STRING)
    private TipoAcordo tipoAcordo;

    @Column(name = "data_promessa_pagamento")
    private LocalDate dataPromessaPagamento;

    @Column(name = "numero_parcelas")
    private Integer numeroParcelas;

    @ManyToOne(fetch = FetchType.LAZY)
    private Divida divida;

    public Cobranca() {
    }


    public Cobranca(LocalDate dataRealizacao,MeioContato meioContato, String agente, TipoAgente tipoAgente, String comentarioAgente,String acordo, TipoAcordo tipoAcordo,LocalDate dataPromessaPagamento, Integer numeroParcelas, Divida divida) {
        this.dataRealizacao = dataRealizacao;
        this.meioContato = meioContato;
        this.agente = agente;
        this.tipoAgente = tipoAgente;
        this.comentarioAgente = comentarioAgente;
        this.acordo = acordo;
        this.tipoAcordo = tipoAcordo;
        this.dataPromessaPagamento = dataPromessaPagamento;
        this.numeroParcelas = numeroParcelas;
        this.divida = divida;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public MeioContato getMeioContato() {
        return meioContato;
    }

    public void setMeioContato(MeioContato meioContato) {
        this.meioContato = meioContato;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public TipoAgente getTipoAgente() {
        return tipoAgente;
    }

    public void setTipoAgente(TipoAgente tipoAgente) {
        this.tipoAgente = tipoAgente;
    }

    public String getComentarioAgente() {
        return comentarioAgente;
    }

    public void setComentarioAgente(String comentarioAgente) {
        this.comentarioAgente = comentarioAgente;
    }

    public String getAcordo() {
        return acordo;
    }

    public void setAcordo(String acordo) {
        this.acordo = acordo;
    }

    public TipoAcordo getTipoAcordo() {
        return tipoAcordo;
    }

    public void setTipoAcordo(TipoAcordo tipoAcordo) {
        this.tipoAcordo = tipoAcordo;
    }

    public LocalDate getDataPromessaPagamento() {
        return dataPromessaPagamento;
    }

    public void setDataPromessaPagamento(LocalDate dataPromessaPagamento) {
        this.dataPromessaPagamento = dataPromessaPagamento;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public Divida getDivida() {
        return divida;
    }

    public void setDivida(Divida divida) {
        this.divida = divida;
    }

    @Override
    public String toString() { //toString de teste
        return "Cobranca{" +
                ", meioContato=" + meioContato +
                ", tipoAgente=" + tipoAgente +
                ", tipoAcordo=" + tipoAcordo +
                ", divida=" + divida +
                '}';
    }

    public Long getIdDivida(){
        return this.divida.getId();
    }


//    public String toString() {
//        return "Cobranca{" +
//                "dataRealizacao=" + dataRealizacao +
//                ", meioContato=" + meioContato +
//                ", agente='" + agente + '\'' +
//                ", tipoAgente=" + tipoAgente +
//                ", comentarioAgente='" + comentarioAgente + '\'' +
//                ", acordo='" + acordo + '\'' +
//                ", tipoAcordo=" + tipoAcordo +
//                ", dataPromessaPagamento=" + dataPromessaPagamento +
//                ", numeroParcelas=" + numeroParcelas +
//                ", divida=" + divida +
//                '}';
//    }
}
