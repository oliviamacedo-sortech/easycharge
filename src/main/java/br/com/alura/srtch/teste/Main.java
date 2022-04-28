package br.com.alura.srtch.teste;

import br.com.alura.srtch.dao.ClienteDao;
import br.com.alura.srtch.dao.EnderecoDao;
import br.com.alura.srtch.dto.ClienteDTO;
import br.com.alura.srtch.mapper.ClienteMapper;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.Endereco;
import br.com.alura.srtch.model.StatusCliente;
import br.com.alura.srtch.service.ClientesPorEstado;
import br.com.alura.srtch.service.ClientesSuspensos;
import br.com.alura.srtch.util.JPAUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import javax.persistence.EntityManager;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    if (args.length <= 0) {
      throw new IllegalArgumentException("Forneça um nome de arquivo.");
    }

    String arquivo = args[0];

    List<Cliente> clientes;


    if (arquivo.endsWith(".csv")) {
      try {
        Reader reader = new FileReader(arquivo);
        CsvToBean<ClienteDTO> csvToBean = new CsvToBeanBuilder<ClienteDTO>(reader)
            .withType(ClienteDTO.class)
            .build();
        clientes = ClienteMapper.passarParaCliente(csvToBean.parse());
      } catch (IOException ex) {
        throw new IllegalStateException(ex);
      }
    } else if (arquivo.endsWith(".json")) {
      try {
        Reader reader = new FileReader(arquivo);
        ObjectMapper mapper = new ObjectMapper();

        clientes = ClienteMapper.passarParaCliente(mapper.readValue(reader, new TypeReference<>() {}));
      } catch (IOException ex) {
        throw new IllegalStateException(ex);
      }
    } else {
      throw new IllegalArgumentException("Formato de arquivo inválido: " + arquivo);
    }

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

    em.getTransaction().commit();

    em.getTransaction().begin();
    clienteDao.buscarTodos();

//    em.getTransaction().commit();
    em.close();
  }

}