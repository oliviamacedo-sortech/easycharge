package com.alura.easycharge.repository;

import com.alura.easycharge.models.Cobranca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CobrancaRepository extends JpaRepository<Cobranca, Long> {
}
