package com.portfolio.springboot.controller;

import com.portfolio.springboot.dto.Mensaje;
import com.portfolio.springboot.dto.SoftSkillsDto;
import com.portfolio.springboot.entity.SoftSkills;
import com.portfolio.springboot.service.SoftSkillService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/softskills")
@CrossOrigin(origins = "*")
public class SoftSkillsController {

    @Autowired
    SoftSkillService softSkillService;

    @GetMapping("/lista")
    public ResponseEntity<List<SoftSkills>> list(){
        List<SoftSkills> list = softSkillService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<SoftSkills> getById(@PathVariable("id") int id){
        if(!softSkillService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        SoftSkills softSkills = softSkillService.getOne(id).get();
        return new ResponseEntity(softSkills, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<SoftSkills> getByNombre(@PathVariable("nombre") String nombre){
        if(!softSkillService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        SoftSkills softSkills = softSkillService.getByNombre(nombre).get();
        return new ResponseEntity(softSkills, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SoftSkillsDto softSkillsDto){
        if(StringUtils.isBlank(softSkillsDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(softSkillService.existsByNombre(softSkillsDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        SoftSkills softSkills = new SoftSkills(softSkillsDto.getNombre());
        softSkillService.save(softSkills);
        return new ResponseEntity(new Mensaje("datos creado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody SoftSkillsDto softSkillsDto){
        if(!softSkillService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(softSkillService.existsByNombre(softSkillsDto.getNombre()) && softSkillService.getByNombre(softSkillsDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(softSkillsDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        SoftSkills softSkills = softSkillService.getOne(id).get();
        softSkills.setNombre(softSkillsDto.getNombre());
        softSkillService.save(softSkills);
        return new ResponseEntity(new Mensaje("datos actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!softSkillService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        softSkillService.delete(id);
        return new ResponseEntity(new Mensaje("datos eliminados"), HttpStatus.OK);
    }
}
