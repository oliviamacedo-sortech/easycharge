package com.alura.easycharge.dao;

import com.alura.easycharge.models.Endereco;

import javax.persistence.EntityManager;
import java.util.List;

public class EnderecoDao {
    private EntityManager em;

    public EnderecoDao(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Endereco endereco){
        this.em.persist(endereco);
    }

    public void atualizar(Endereco endereco){
        this.em.merge(endereco);
    }

    public void remover(Endereco endereco){
        endereco = em.merge(endereco);
        this.em.remove(endereco);
    }
}
