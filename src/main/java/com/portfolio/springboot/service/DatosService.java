package com.portfolio.springboot.service;

import com.portfolio.springboot.entity.Datos;
import com.portfolio.springboot.repository.DatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DatosService {

    @Autowired
    DatosRepository datosRepository;


    public List<Datos> list(){
        return datosRepository.findAll();
    }
    public Optional<Datos> getOne(int id){
        return datosRepository.findById(id);
    }

    public Optional<Datos> getByNombre(String nombre){
        return datosRepository.findByNombre(nombre);
    }

    public void  save(Datos datos){
        datosRepository.save(datos);
    }

    public void delete(int id){
        datosRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return datosRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return datosRepository.existsByNombre(nombre);
    }
}
