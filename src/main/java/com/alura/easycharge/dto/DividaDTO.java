package com.alura.easycharge.dto;

import com.alura.easycharge.models.Divida;
import com.alura.easycharge.models.StatusDivida;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DividaDTO {

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    private LocalDate dataAbertura = LocalDate.now();

    @PastOrPresent
    private LocalDate dataQuitacao;

    @NotNull
    private StatusDivida statusDivida = StatusDivida.ABERTA;

    private String descricaoQuitacao;

    @NotNull
    private Long idCliente;

    public DividaDTO() {
    }

    public DividaDTO(Divida divida){
        this.valor = divida.getValor();
        this.dataAbertura = divida.getDataAbertura();
        this.dataQuitacao = divida.getDataQuitacao();
        this.statusDivida = divida.getStatusDivida();
        this.descricaoQuitacao = divida.getDescricaoQuitacao();
        this.idCliente = divida.getCliente().getId();
    }


    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public LocalDate getDataQuitacao() {
        return dataQuitacao;
    }

    public StatusDivida getStatusDivida() {
        return statusDivida;
    }

    public String getDescricaoQuitacao() {
        return descricaoQuitacao;
    }

    public Long getIdCliente() {
        return idCliente;
    }

        public static List<DividaDTO> converter(List<Divida> dividas){
        return dividas.stream().map(DividaDTO::new).collect(Collectors.toList());
    }
}
