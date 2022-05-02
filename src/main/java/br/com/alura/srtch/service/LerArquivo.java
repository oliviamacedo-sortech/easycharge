package br.com.alura.srtch.service;

import br.com.alura.srtch.dto.ClienteDTO;
import br.com.alura.srtch.mapper.ClienteMapper;
import br.com.alura.srtch.model.Cliente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class LerArquivo {
    public List<Cliente> leituraArquivo(String arquivo){
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
        return clientes;
    }
}
