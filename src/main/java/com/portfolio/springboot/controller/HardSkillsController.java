package com.portfolio.springboot.controller;

import com.portfolio.springboot.dto.HardSkillsDto;
import com.portfolio.springboot.dto.Mensaje;
import com.portfolio.springboot.entity.HardSkills;
import com.portfolio.springboot.service.HardSkillsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hardskills")
@CrossOrigin(origins = "*")
public class HardSkillsController {

    @Autowired
    HardSkillsService hardSkillsService;

    @GetMapping("/lista")
    public ResponseEntity<List<HardSkills>> list(){
        List<HardSkills> list = hardSkillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<HardSkills> getById(@PathVariable("id") int id){
        if(!hardSkillsService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        HardSkills hardSkills = hardSkillsService.getOne(id).get();
        return new ResponseEntity(hardSkills, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<HardSkills> getByNombre(@PathVariable("nombre") String nombre){
        if(!hardSkillsService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        HardSkills hardSkills = hardSkillsService.getByNombre(nombre).get();
        return new ResponseEntity(hardSkills, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody HardSkillsDto hardSkillsDto){
        if(StringUtils.isBlank(hardSkillsDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(hardSkillsService.existsByNombre(hardSkillsDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        HardSkills datos = new HardSkills(hardSkillsDto.getNombre(),hardSkillsDto.getLenguaje(),hardSkillsDto.getNivel(),hardSkillsDto.getDato());
        hardSkillsService.save(datos);
        return new ResponseEntity(new Mensaje("datos creado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody HardSkillsDto hardSkillsDto){
        if(!hardSkillsService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(hardSkillsService.existsByNombre(hardSkillsDto.getNombre()) && hardSkillsService.getByNombre(hardSkillsDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(hardSkillsDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        HardSkills hardSkills = hardSkillsService.getOne(id).get();
        hardSkills.setNombre(hardSkillsDto.getNombre());
        hardSkillsService.save(hardSkills);
        return new ResponseEntity(new Mensaje("datos actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!hardSkillsService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        hardSkillsService.delete(id);
        return new ResponseEntity(new Mensaje("datos eliminados"), HttpStatus.OK);
    }
}
