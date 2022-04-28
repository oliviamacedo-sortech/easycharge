package br.com.alura.srtch.teste;

import br.com.alura.srtch.dao.ClienteDao;
import br.com.alura.srtch.dao.CobrancaDao;
import br.com.alura.srtch.dao.DividaDao;
import br.com.alura.srtch.model.*;
import br.com.alura.srtch.service.ClientesPorEstado;
import br.com.alura.srtch.service.ClientesSuspensos;
import br.com.alura.srtch.service.LerArquivo;
import br.com.alura.srtch.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
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

    List<Divida> dividas = new ArrayList<>();
    List<Cobranca> cobrancas = new ArrayList<>();

    dividas.add(new Divida(new BigDecimal(400), StatusDivida.ABERTA, clientes.get(0)));
    dividas.add(new Divida(new BigDecimal(1200), StatusDivida.ABERTA, clientes.get(0)));
    dividas.add(new Divida(new BigDecimal(2200), StatusDivida.ABERTA, clientes.get(1)));
    cobrancas.add(new Cobranca(MeioContato.EMAIL,TipoAgente.EXTERNO, TipoAcordo.PROMESSA, dividas.get(0)));
    cobrancas.add(new Cobranca(MeioContato.EMAIL,TipoAgente.INTERNO, TipoAcordo.PROMESSA, dividas.get(0)));
    cobrancas.add(new Cobranca(MeioContato.EMAIL,TipoAgente.EXTERNO, TipoAcordo.PARCELAMENTO, dividas.get(0)));
    cobrancas.add(new Cobranca(MeioContato.EMAIL,TipoAgente.EXTERNO, TipoAcordo.PROMESSA, dividas.get(1)));


    EntityManager em = JPAUtil.getEntityManager();

    ClienteDao clienteDao = new ClienteDao(em);
    CobrancaDao cobrancaDao= new CobrancaDao(em);
    DividaDao dividaDao = new DividaDao(em);

    em.getTransaction().begin();
    for (Cliente cliente : clientes) {
      clienteDao.cadastrar(cliente);
    }

    for (Divida divida : dividas) {
      dividaDao.cadastrar(divida);
    }

    for (Cobranca cobranca : cobrancas) {
      cobrancaDao.cadastrar(cobranca);
    }

    System.out.println(dividaDao.buscarTodos());
    dividaDao.remover(dividas.get(1));
//    dividas.get(1).setStatusDivida(StatusDivida.QUITADA);
    System.out.println(dividaDao.buscarTodos());

//    List<Divida> dividasSemCobranca = dividaDao.dividasSemCobranca();
//    for(Divida divida : dividasSemCobranca) {
//      System.out.println(divida);
//    }
//
//
//    List<Cobranca> cobrancasTipoParcelamento = cobrancaDao.tipoDeAcordo(TipoAcordo.PARCELAMENTO);
//    for(Cobranca cobranca : cobrancasTipoParcelamento) {
//      System.out.println(cobranca);
//    }
//
//    System.out.println(cobrancaDao.contagemCobrancas(clientes.get(0).getCpf())); // cpf primeiro cliente
//


    em.getTransaction().commit();
    em.close();
  }
}