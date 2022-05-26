package com.alura.easycharge.mapper;

import com.alura.easycharge.form.CobrancaForm;
import com.alura.easycharge.models.Cobranca;
import com.alura.easycharge.models.Divida;
import com.alura.easycharge.models.StatusDivida;
import com.alura.easycharge.repository.CobrancaRepository;
import com.alura.easycharge.repository.DividaRepository;

public class CobrancaMapper {
    public Cobranca cadastrar (CobrancaForm cobrancaForm, CobrancaRepository cobrancaRepository, DividaRepository dividaRepository){
        Divida divida = dividaRepository.getById(cobrancaForm.getIdDivida());
        Cobranca cobranca = new Cobranca(cobrancaForm.getDataRealizacao(),cobrancaForm.getMeioContato(),cobrancaForm.getAgente(),cobrancaForm.getTipoAgente(),cobrancaForm.getComentarioAgente(),cobrancaForm.getAcordo(),cobrancaForm.getTipoAcordo(),cobrancaForm.getDataPromessaPagamento(),cobrancaForm.getNumeroParcelas(),divida);

//        if(cobrancaRepository.somaCobrancasDivida(cobrancaForm.getIdDivida()) > 3){
//            divida.setStatusDivida(StatusDivida.RECUPERACAO_JUDICIAL);
//        }

        return cobranca;
    }

}
