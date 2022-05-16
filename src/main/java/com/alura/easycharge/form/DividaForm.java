package com.alura.easycharge.form;

import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.models.StatusDivida;

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

//    public DividaForm(Divida divida){
//        this.valor = divida.getValor();
//        this.dataAbertura = divida.getDataAbertura();
//        this.dataQuitacao = divida.getDataQuitacao();
//        this.statusDivida = divida.getStatusDivida();
//        this.descricaoQuitacao = divida.getDescricaoQuitacao();
//        this.idCliente = divida.getCliente().getId();
//    }

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


//    public static List<DividaForm> converter(List<Divida> dividas){
//        return dividas.stream().map(DividaForm::new).collect(Collectors.toList());
//    }
}
