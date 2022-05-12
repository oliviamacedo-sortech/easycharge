package com.alura.easycharge.form;

import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.models.Cobranca;
import com.alura.easycharge.models.StatusDivida;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DividaForm {

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
    private Cliente cliente;

    @NotNull
    private final List<Cobranca> cobrancas = new ArrayList<>();

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

    public Cliente getCliente() {
        return cliente;
    }

    public List<Cobranca> getCobrancas() {
        return cobrancas;
    }
}
