package br.com.alura.srtch;

import br.com.alura.srtch.dao.ClienteDao;
import br.com.alura.srtch.dao.EnderecoDao;
import br.com.alura.srtch.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;


public class CadastroDeCliente {
    public static void main(String[] args) {
        cadastrarCliente();
        Long id = 1l;
        EntityManager em = JPAUtil.getEntityManager();
        ClienteDao dao = new ClienteDao(em);

        Cliente c = dao.buscarPorId(1l);
        System.out.println(c.getNome());

        List<Cliente> todos = dao.buscarTodos();
        //todos.forEach(c -> System.out.println(c.getNome()));
    }

    public static void cadastrarCliente() {


    Cliente cliente = new Cliente();

    EntityManager em = JPAUtil.getEntityManager();
    ClienteDao dao = new ClienteDao(em);
    EnderecoDao edao = new EnderecoDao(em);

        em.getTransaction().

    begin();
        dao.cadastrar(cliente);
        em.getTransaction().

    commit();

        em.merge(cliente);
        em.remove(cliente);
        em.flush();
        em.close();
}


}
