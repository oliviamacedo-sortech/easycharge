package com.alura.easycharge.form;

import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.models.Divida;
import com.alura.easycharge.models.StatusDivida;
import com.alura.easycharge.repository.DividaRepository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public class DividaForm {

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    private LocalDate dataAbertura;

    @PastOrPresent
    private LocalDate dataQuitacao;

    @NotNull
    private StatusDivida statusDivida = StatusDivida.ABERTA;

    private String descricaoQuitacao;

    @NotNull
    private Long idCliente;

    public DividaForm() {
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

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Divida atualizar(Long id, DividaRepository dividaRepository) {
        Divida divida = dividaRepository.getById(id);
        divida.setValor(this.valor);
        divida.setDataAbertura(this.dataAbertura);
        divida.setDataQuitacao(this.dataQuitacao);
        divida.setStatusDivida(this.statusDivida);
        divida.setDescricaoQuitacao(this.descricaoQuitacao);
        divida.getCliente().setId(this.idCliente);
        return divida;
    }
}
