package com.portfolio.springboot.repository;

import com.portfolio.springboot.entity.SoftSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SoftSkillsRepository extends JpaRepository<SoftSkills, Integer> {

    Optional<SoftSkills> findByNombre(String nombre);
    boolean existsByNombre(String nombre);

}
