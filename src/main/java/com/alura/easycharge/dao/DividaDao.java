package com.alura.easycharge.dao;

import com.alura.easycharge.models.Divida;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class DividaDao {
    private EntityManager em;

    public DividaDao(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Divida divida){
        this.em.persist(divida);
    }

    public void atualizar(Divida divida){
        this.em.merge(divida);
    }

    public void remover(Divida divida){
        divida = em.merge(divida);
        this.em.remove(divida);
    }

    public List<Divida> buscarTodos(){
        String jpql = "SELECT d FROM Divida d";
        return em.createQuery(jpql, Divida.class).getResultList();
    }

    public BigDecimal somaDividas(String cpf){
        String jpql = "SELECT SUM(d.valorDivida) FROM Divida d WHERE d.cliente.cpf = :cpf";
        return em.createQuery(jpql, BigDecimal.class).setParameter("cpf", cpf).getSingleResult();
    }

    public List<Divida> dividasSemCobranca(){
        String jpql = "SELECT d FROM Divida d WHERE d.cobrancas IS EMPTY";
        return em.createQuery(jpql, Divida.class).getResultList();
    }
}
