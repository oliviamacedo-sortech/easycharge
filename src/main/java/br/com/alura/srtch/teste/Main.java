package br.com.alura.srtch.teste;

import br.com.alura.srtch.dao.ClienteDao;
import br.com.alura.srtch.dao.EnderecoDao;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.service.ClientesPorEstado;
import br.com.alura.srtch.service.ClientesSuspensos;
import br.com.alura.srtch.service.LerArquivo;
import br.com.alura.srtch.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    if (args.length <= 0) {
      throw new IllegalArgumentException("Forneça um nome de arquivo.");
    }

    String arquivo = args[0];

    List<Cliente> clientes = new LerArquivo().leituraArquivo(arquivo);


    System.out.println("# Limites de dívidas dos clientes");
    for (Cliente cliente : clientes) {
      BigDecimal limiteDivida = cliente.getRenda().multiply(BigDecimal.valueOf(12));
      System.out.printf("- o limite máximo de dívida para %s é de R$ %.2f.\n", cliente.getNome(), limiteDivida);
    }

    new ClientesSuspensos().somaRendaClientesSuspensos(clientes);


    ClientesPorEstado clientesPorEstado = new ClientesPorEstado();
    for (Cliente cliente : clientes) {
      clientesPorEstado.adicionaCliente(cliente);
    }
    System.out.println("# Clientes por estado");
    for (String estado : clientesPorEstado.keySet()) {
      List<Cliente> clientesDoEstado = clientesPorEstado.get(estado);
      System.out.printf("- o estado %s tem %d cliente(s) cadastrado(s).\n", estado, clientesDoEstado.size());
    }

    testesBancos(clientes);

  }

  private static void testesBancos(List<Cliente> clientes) {
    EntityManager em = JPAUtil.getEntityManager();

    ClienteDao clienteDao = new ClienteDao(em);
    EnderecoDao enderecoDao = new EnderecoDao(em);

    em.getTransaction().begin();
    for (Cliente cliente : clientes) {
      clienteDao.cadastrar(cliente);
    }

//    clienteDao.buscarPorNome("");

    em.getTransaction().commit();
    em.close();
  }

}