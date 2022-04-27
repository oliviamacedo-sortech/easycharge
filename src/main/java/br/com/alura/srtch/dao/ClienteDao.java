package br.com.alura.srtch.dao;

import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.StatusCliente;

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

    public Cliente buscarPorId(String cpf){
       return em.find(Cliente.class, cpf);
    }

    public List<Cliente> buscarTodos(){
        String jpql = "SELECT * FROM Cliente c";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }

    public List<Cliente> buscarPorStatus(StatusCliente statusCliente){
        String jpql = "SELECT * FROM Cliente c WHERE c.status = :status";
        return em.createQuery(jpql, Cliente.class).setParameter("status", statusCliente).getResultList();
    }

    public List<Cliente> buscarPorNome(String nome){
        String jpql = "SELECT * FROM Cliente c WHERE c.nome = :nome";
        return em.createQuery(jpql, Cliente.class).setParameter("nome", nome).getResultList();
    }
}
