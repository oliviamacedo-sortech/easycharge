package br.com.alura.srtch.teste;

import br.com.alura.srtch.dto.ClienteDTO;
import br.com.alura.srtch.dto.ObjetoCliente;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.service.ClientesPorEstado;
import br.com.alura.srtch.model.StatusCliente;
import br.com.alura.srtch.service.ClientesSuspensos;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.collections.functors.ChainedClosure;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
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
        CsvToBean<Cliente> csvToBean = new CsvToBeanBuilder<Cliente>(reader)
            .withType(Cliente.class)
            .build();
        clientes = csvToBean.parse();
      } catch (IOException ex) {
        throw new IllegalStateException(ex);
      }
    } else if (arquivo.endsWith(".json")) {
      try {
        Reader reader = new FileReader(arquivo);
        ObjectMapper mapper = new ObjectMapper();

        clientes = mapper.readValue(reader, new TypeReference<>() {
        });
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


  }

}