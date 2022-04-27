package br.com.alura.srtch.dao;

import br.com.alura.srtch.model.Cobranca;

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
        String jpql = "SELECT * FROM Cobranca co";
        return em.createQuery(jpql, Cobranca.class).getResultList();
    }
}
