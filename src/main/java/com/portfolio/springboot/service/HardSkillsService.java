package com.portfolio.springboot.service;

import com.portfolio.springboot.entity.HardSkills;
import com.portfolio.springboot.repository.HardSkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HardSkillsService {
    @Autowired
    HardSkillsRepository hardSkillsRepository;

    public List<HardSkills> list(){
        return hardSkillsRepository.findAll();
    }

    public Optional<HardSkills> getOne(int id){
        return hardSkillsRepository.findById(id);
    }

    public Optional<HardSkills> getByNombre(String nombre){
        return hardSkillsRepository.findByNombre(nombre);
    }

    public void  save(HardSkills hardSkills){
        hardSkillsRepository.save(hardSkills);
    }

    public void delete(int id){
        hardSkillsRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return hardSkillsRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return hardSkillsRepository.existsByNombre(nombre);
    }

}

