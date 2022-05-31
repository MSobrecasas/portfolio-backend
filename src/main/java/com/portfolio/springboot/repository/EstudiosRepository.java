package com.portfolio.springboot.repository;

import com.portfolio.springboot.entity.Estudios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudiosRepository extends JpaRepository<Estudios, Integer> {

    Optional<Estudios> findByNombre(String nombre);
    boolean existsByNombre(String nombre);

}
