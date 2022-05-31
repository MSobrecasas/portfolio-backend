package com.portfolio.springboot.controller;

import com.portfolio.springboot.dto.DatosDto;
import com.portfolio.springboot.dto.Mensaje;
import com.portfolio.springboot.entity.Datos;
import com.portfolio.springboot.service.DatosService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/datos")
@CrossOrigin(origins = "*")
public class DatosController {
    @Autowired
    DatosService datosService;

    @GetMapping("/lista")
    public ResponseEntity<List<Datos>> list(){
        List<Datos> list = datosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<Datos> getById(@PathVariable("id") int id){
        if(!datosService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Datos datos = datosService.getOne(id).get();
        return new ResponseEntity(datos, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Datos> getByNombre(@PathVariable("nombre") String nombre){
        if(!datosService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Datos datos = datosService.getByNombre(nombre).get();
        return new ResponseEntity(datos, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DatosDto datosDto){
        if(StringUtils.isBlank(datosDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(datosService.existsByNombre(datosDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Datos datos = new Datos(datosDto.getNombre(),datosDto.getBanner(),datosDto.getImgPerfil(),datosDto.getEmail(),
                datosDto.getPosicion(),datosDto.getTitulo(),datosDto.getUbicacion(),datosDto.getLogo(),
                datosDto.getLinkedIn(),datosDto.getGithub());
        datosService.save(datos);
        return new ResponseEntity(new Mensaje("datos creado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody DatosDto datosDto){
        if(!datosService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(datosService.existsByNombre(datosDto.getNombre()) && datosService.getByNombre(datosDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(datosDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Datos datos = datosService.getOne(id).get();
        datos.setNombre(datosDto.getNombre());
        datosService.save(datos);
        return new ResponseEntity(new Mensaje("datos actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!datosService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        datosService.delete(id);
        return new ResponseEntity(new Mensaje("datos eliminados"), HttpStatus.OK);
    }
}
