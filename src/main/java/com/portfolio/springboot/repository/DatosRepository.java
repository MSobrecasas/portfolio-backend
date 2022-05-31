package com.portfolio.springboot.repository;

import com.portfolio.springboot.entity.Datos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DatosRepository extends JpaRepository<Datos, Integer> {

    Optional<Datos> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
