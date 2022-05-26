package com.alura.easycharge.repository;

import com.alura.easycharge.dto.ClienteDTO;
import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.projection.ClienteRelatorioProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query(value = "select nome, sum(dividas.valor_divida) as totalDividas , contagemCobrancas.contagem as cobrancas\n" +
            " from clientes\n" +
            " left join dividas\n" +
            " on clientes.id=dividas.cliente_id\n" +
            " left join (\n" +
            " select dividas.cliente_id as clienteId, count(cobrancas.id)  as contagem\n" +
            " from cobrancas\n" +
            " inner join dividas\n" +
            " on dividas.id = cobrancas.divida_id\n" +
            " group by dividas.cliente_id\n" +
            " ) as contagemCobrancas\n" +
            " on contagemCobrancas.clienteId = clientes.id\n" +
            " group by clientes.id", nativeQuery = true )
    List<ClienteRelatorioProjection> findTotalDividasCobrancasPorNome();
}
