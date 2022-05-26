package com.alura.easycharge.dto;

import com.alura.easycharge.models.Cobranca;
import com.alura.easycharge.models.MeioContato;
import com.alura.easycharge.models.TipoAcordo;
import com.alura.easycharge.models.TipoAgente;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public class CobrancaDTO {
    private Long id;

    private LocalDate dataRealizacao;

    private MeioContato meioContato;

    private String agente;

    private TipoAgente tipoAgente;

    private String comentarioAgente;

    private String acordo;

    private TipoAcordo tipoAcordo;

    private LocalDate dataPromessaPagamento;

    private Integer numeroParcelas;

    private Long idDivida;

    public CobrancaDTO() {
    }

    public CobrancaDTO(Cobranca cobranca) {
        this.id = cobranca.getId();
        this.dataRealizacao = cobranca.getDataRealizacao();
        this.meioContato = cobranca.getMeioContato();
        this.agente = cobranca.getAgente();
        this.tipoAgente = cobranca.getTipoAgente();
        this.comentarioAgente = cobranca.getComentarioAgente();
        this.acordo = cobranca.getAcordo();
        this.tipoAcordo = cobranca.getTipoAcordo();
        this.dataPromessaPagamento = cobranca.getDataPromessaPagamento();
        this.numeroParcelas = cobranca.getNumeroParcelas();
        this.idDivida = cobranca.getIdDivida();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public MeioContato getMeioDeContato() {
        return meioContato;
    }

    public String getAgente() {
        return agente;
    }

    public TipoAgente getTipoAgente() {
        return tipoAgente;
    }

    public String getComentarioAgente() {
        return comentarioAgente;
    }

    public String getAcordo() {
        return acordo;
    }

    public TipoAcordo getTipoAcordo() {
        return tipoAcordo;
    }

    public LocalDate getDataPromessaPagamento() {
        return dataPromessaPagamento;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public Long getIdDivida() {
        return idDivida;
    }

    public static Page<CobrancaDTO> converter(Page<Cobranca> cobrancas){
        return cobrancas.map(CobrancaDTO::new);
    }
}
