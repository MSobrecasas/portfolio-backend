package com.portfolio.springboot.dto;

import javax.validation.constraints.NotBlank;

public class HardSkillsDto {

    @NotBlank
    private String nombre;

    @NotBlank
    private String lenguaje;

    @NotBlank
    private String nivel;

    @NotBlank
    private int  dato;

    public HardSkillsDto(String nombre, String lenguaje, String nivel, int dato) {
        this.nombre = nombre;
        this.lenguaje = lenguaje;
        this.nivel = nivel;
        this.dato = dato;
    }

    public HardSkillsDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }
}
