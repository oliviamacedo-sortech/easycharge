package com.alura.easycharge.projection;

import java.math.BigDecimal;

public interface ClienteRelatorioProjection {
    String getNome();
    BigDecimal getTotalDividas();
    Integer getCobrancas();
}
