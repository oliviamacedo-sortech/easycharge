package br.com.alura.srtch.dao;

import br.com.alura.srtch.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDao {

    private EntityManager em;

    public ClienteDao(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Cliente cliente){
        this.em.persist(cliente);
    }

    public void atualizar(Cliente cliente){
        this.em.merge(cliente);
    }

    public void remover(Cliente cliente){
        cliente = em.merge(cliente);
        this.em.remove(cliente);
    }

    public Cliente buscarPorId(Long id){
       return em.find(Cliente.class, 1);
    }

    public List<Cliente> buscarTodos(){
        String jpql = "SELECT * FROM Cliente c";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }
}
