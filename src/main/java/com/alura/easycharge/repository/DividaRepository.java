package com.alura.easycharge.repository;

import com.alura.easycharge.models.Divida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DividaRepository extends JpaRepository<Divida, Long> {

}
