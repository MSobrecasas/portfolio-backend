package com.portfolio.springboot.repository;


import com.portfolio.springboot.entity.HardSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HardSkillsRepository extends JpaRepository<HardSkills, Integer> {

    Optional<HardSkills> findByNombre(String nombre);
    boolean existsByNombre(String nombre);

}
