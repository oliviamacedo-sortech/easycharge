package br.com.alura.srtch.dao;

import br.com.alura.srtch.Cliente;
import br.com.alura.srtch.Endereco;

import javax.persistence.EntityManager;

public class EnderecoDao {
    private EntityManager em;

    public EnderecoDao(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Endereco endereco){
        this.em.persist(endereco);
    }
}
