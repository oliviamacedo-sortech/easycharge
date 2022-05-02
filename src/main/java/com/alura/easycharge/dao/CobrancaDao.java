package com.alura.easycharge.dao;

import com.alura.easycharge.models.Cobranca;
import com.alura.easycharge.models.TipoAcordo;

import javax.persistence.EntityManager;
import java.util.List;

public class CobrancaDao {

    private EntityManager em;

    public CobrancaDao(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Cobranca cobranca){
        this.em.persist(cobranca);
    }

    public void atualizar(Cobranca cobranca){
        this.em.merge(cobranca);
    }

    public void remover(Cobranca cobranca){
        cobranca = em.merge(cobranca);
        this.em.remove(cobranca);
    }

    public List<Cobranca> buscarTodos(){
        String jpql = "SELECT co FROM Cobranca co";
        return em.createQuery(jpql, Cobranca.class).getResultList();
    }

    public List<Cobranca> tipoDeAcordo(TipoAcordo tipoAcordo){
        String jpql = "SELECT co FROM Cobranca co WHERE co.tipoAcordo = :tipoAcordo";
        return em.createQuery(jpql, Cobranca.class).setParameter("tipoAcordo", tipoAcordo).getResultList();
    }

    public Long contagemCobrancas(String cpf){
        String jpql = "SELECT COUNT(co) FROM Cobranca co WHERE co.divida.cliente.cpf = :cpf";
        return em.createQuery(jpql, Long.class).setParameter("cpf", cpf).getSingleResult();
    }

}
