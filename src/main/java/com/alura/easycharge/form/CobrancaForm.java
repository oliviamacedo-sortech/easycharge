package com.alura.easycharge.form;

import com.alura.easycharge.dto.ClienteDTOJson;
import com.alura.easycharge.models.*;
import org.springframework.data.domain.Page;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class CobrancaForm {

    @NotNull
    @PastOrPresent
    private LocalDate dataRealizacao;

    @NotNull
    private MeioContato meioContato;

    @NotBlank
    private String agente;

    @NotNull
    private TipoAgente tipoAgente;

    @NotBlank
    private String comentarioAgente;

    private String acordo;

    private TipoAcordo tipoAcordo;

    @Future
    private LocalDate dataPromessaPagamento;

    @Min(1)
    @Max(12)
    private int numeroParcelas;

    @NotNull
    private Long idDivida;

    public CobrancaForm() {
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

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public Long getIdDivida() {
        return idDivida;
    }

    public void setIdDivida(Long idDivida) {
        this.idDivida = idDivida;
    }

}
