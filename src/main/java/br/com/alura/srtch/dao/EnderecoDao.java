package br.com.alura.srtch.dao;

import br.com.alura.srtch.Cliente;
import br.com.alura.srtch.Endereco;

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

    public Endereco buscarPorId(Long id){
        return em.find(Endereco.class, 1);
    }

    public List<Endereco> buscarTodos(){
        String jpql = "SELECT * FROM Endereco e";
        return em.createQuery(jpql, Endereco.class).getResultList();
    }
}
