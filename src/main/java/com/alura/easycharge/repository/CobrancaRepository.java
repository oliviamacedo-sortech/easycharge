package com.alura.easycharge.repository;

import com.alura.easycharge.models.Cobranca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CobrancaRepository extends JpaRepository<Cobranca, Long> {
    //todo Mudar nome
    @Query("SELECT COUNT(c) FROM Cobranca c " +
            "WHERE c.divida.id = :id ")
    int somaCobrancasDivida(@Param("id") Long idDivida);
}
