package com.alura.easycharge.repository;

import com.alura.easycharge.dto.ClienteDTO;
import com.alura.easycharge.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
