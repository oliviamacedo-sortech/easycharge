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
    private BigDecimal valorDivida;
    private Date dataAbertura;
    private Date dataQuitacao;

    @Enumerated(EnumType.STRING)
    private StatusDivida statusDivida;
    private String descricaoQuitacao;

    @OneToMany
    private Cliente cliente;
}
