package com.portfolio.springboot.controller;

import com.portfolio.springboot.dto.EstudiosDto;
import com.portfolio.springboot.dto.Mensaje;
import com.portfolio.springboot.entity.Estudios;
import com.portfolio.springboot.service.EstudiosService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudios")
@CrossOrigin(origins = "*")
public class EstudiosController {

    @Autowired
    EstudiosService estudiosService;

    @GetMapping("/lista")
    public ResponseEntity<List<Estudios>> list(){
        List<Estudios> list = estudiosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<Estudios> getById(@PathVariable("id") int id){
        if(!estudiosService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Estudios estudios = estudiosService.getOne(id).get();
        return new ResponseEntity(estudios, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Estudios> getByNombre(@PathVariable("nombre") String nombre){
        if(!estudiosService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Estudios es = estudiosService.getByNombre(nombre).get();
        return new ResponseEntity(es, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EstudiosDto estudiosDto){
        if(StringUtils.isBlank(estudiosDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(estudiosService.existsByNombre(estudiosDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Estudios estudios = new Estudios(estudiosDto.getNombre(),estudiosDto.getInstitucion(),estudiosDto
                .getNombreInstitucion(),estudiosDto.getFecha(),estudiosDto.getLogo());
        estudiosService.save(estudios);
        return new ResponseEntity(new Mensaje("estudios creado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody EstudiosDto estudiosDto){
        if(!estudiosService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(estudiosService.existsByNombre(estudiosDto.getNombre()) && estudiosService.getByNombre(estudiosDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(estudiosDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Estudios estudios = estudiosService.getOne(id).get();
        estudios.setNombre(estudiosDto.getNombre());
        estudiosService.save(estudios);
        return new ResponseEntity(new Mensaje("estudios actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!estudiosService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        estudiosService.delete(id);
        return new ResponseEntity(new Mensaje("datos eliminados"), HttpStatus.OK);
    }

}
