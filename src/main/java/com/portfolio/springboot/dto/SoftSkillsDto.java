package com.portfolio.springboot.dto;

import javax.validation.constraints.NotBlank;

public class SoftSkillsDto {
    @NotBlank
    private String nombre;

    public SoftSkillsDto() {
    }

    public SoftSkillsDto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
