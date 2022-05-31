package com.portfolio.springboot.service;


import com.portfolio.springboot.entity.SoftSkills;
import com.portfolio.springboot.repository.SoftSkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SoftSkillService {

    @Autowired
    SoftSkillsRepository softSkillsRepository;


    public List<SoftSkills> list(){
        return softSkillsRepository.findAll();
    }
    public Optional<SoftSkills> getOne(int id){
        return softSkillsRepository.findById(id);
    }

    public Optional<SoftSkills> getByNombre(String nombre){
        return softSkillsRepository.findByNombre(nombre);
    }

    public void  save(SoftSkills softSkills){
        softSkillsRepository.save(softSkills);
    }

    public void delete(int id){
        softSkillsRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return softSkillsRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return softSkillsRepository.existsByNombre(nombre);
    }

}
