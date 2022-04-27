package br.com.alura.srtch.teste;

import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.dao.ClienteDao;
import br.com.alura.srtch.dao.EnderecoDao;
import br.com.alura.srtch.model.Endereco;
import br.com.alura.srtch.model.StatusCliente;
import br.com.alura.srtch.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;


public class TesteDao {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        Endereco endereco = new Endereco("0", "212", "Apartamento", "Guara I", "Brasília", "DF");
        Cliente cliente = new Cliente(StatusCliente.ATIVO, endereco, "Olívia Gonzalez", "03184520145", "61998219292", "olivia@gmail.com", "Desenvolvedor", new BigDecimal(1000));

        ClienteDao clienteDao = new ClienteDao(em);
        EnderecoDao enderecoDao = new EnderecoDao(em);

        em.getTransaction().begin();
        enderecoDao.cadastrar(endereco);
        clienteDao.cadastrar(cliente);
        clienteDao.buscarPorNome("Yasmin Ester Lara Nogueira");

        em.getTransaction().commit();
        em.close();

    }
}
