package br.com.alura.srtch.vo;

import java.math.BigDecimal;
import java.util.SplittableRandom;

public class RelatorioDeClientes {

    private String nomeCliente;
    private BigDecimal valorTotalDividas;
    private Long quantidadeCobrancas;

    public RelatorioDeClientes(String nomeCliente, BigDecimal valorTotalDividas, Long quantidadeCobrancas) {
        this.nomeCliente = nomeCliente;
        this.valorTotalDividas = valorTotalDividas;
        this.quantidadeCobrancas = quantidadeCobrancas;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public BigDecimal getValorTotalDividas() {
        return valorTotalDividas;
    }

    public Long getQuantidadeCobrancas() {
        return quantidadeCobrancas;
    }
}
