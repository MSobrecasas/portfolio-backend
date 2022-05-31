package com.portfolio.springboot.service;

import com.portfolio.springboot.entity.Datos;
import com.portfolio.springboot.entity.Estudios;
import com.portfolio.springboot.repository.EstudiosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EstudiosService {
    @Autowired
    EstudiosRepository estudiosRepository;


    public List<Estudios> list(){
        return estudiosRepository.findAll();
    }
    public Optional<Estudios> getOne(int id){
        return estudiosRepository.findById(id);
    }

    public Optional<Estudios> getByNombre(String nombre){
        return estudiosRepository.findByNombre(nombre);
    }

    public void  save(Estudios estudios){
        estudiosRepository.save(estudios);
    }

    public void delete(int id){
        estudiosRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return estudiosRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return estudiosRepository.existsByNombre(nombre);
    }
}
