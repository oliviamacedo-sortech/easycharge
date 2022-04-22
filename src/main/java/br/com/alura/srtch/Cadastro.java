package br.com.alura.srtch;

import br.com.alura.srtch.dao.ClienteDao;
import br.com.alura.srtch.dao.EnderecoDao;
import br.com.alura.srtch.util.JPAUtil;

import javax.persistence.EntityManager;


public class Cadastro {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();

        EntityManager em = JPAUtil.getEntityManager();
        ClienteDao dao = new ClienteDao(em);
        EnderecoDao edao = new EnderecoDao(em);

        em.getTransaction().begin();
        dao.cadastrar(cliente);
        em.getTransaction().commit();
        em.close();

        em.merge(cliente);


    }
}
