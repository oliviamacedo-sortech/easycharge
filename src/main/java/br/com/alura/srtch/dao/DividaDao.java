package br.com.alura.srtch.dao;

import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.Divida;

import javax.persistence.EntityManager;
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
}
