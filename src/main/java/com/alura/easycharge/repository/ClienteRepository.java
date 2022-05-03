package com.alura.easycharge.repository;

import com.alura.easycharge.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
