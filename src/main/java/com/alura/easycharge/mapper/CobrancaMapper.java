package com.alura.easycharge.mapper;

import com.alura.easycharge.form.CobrancaForm;
import com.alura.easycharge.models.Cobranca;
import com.alura.easycharge.models.Divida;
import com.alura.easycharge.repository.DividaRepository;

public class CobrancaMapper {
    public Cobranca cadastrar (CobrancaForm cobrancaForm, DividaRepository dividaRepository){
        Divida divida = dividaRepository.getById(cobrancaForm.getIdDivida());
        return new Cobranca(cobrancaForm.getDataRealizacao(),cobrancaForm.getMeioContato(),cobrancaForm.getAgente(),cobrancaForm.getTipoAgente(),cobrancaForm.getComentarioAgente(),cobrancaForm.getAcordo(),cobrancaForm.getTipoAcordo(),cobrancaForm.getDataPromessaPagamento(),cobrancaForm.getNumeroParcelas(),divida);
    }

}
