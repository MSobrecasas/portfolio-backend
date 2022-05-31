package com.portfolio.springboot.dto;

import javax.validation.constraints.NotBlank;

public class EstudiosDto {

    @NotBlank
    private String nombre;
    @NotBlank
    private String institucion;
    @NotBlank
    private String nombreInstitucion;
    @NotBlank
    private String fecha;
    @NotBlank
    private String logo;

    public EstudiosDto() {
    }

    public EstudiosDto(String nombre, String institucion, String nombreInstitucion, String fecha, String logo) {
        this.nombre = nombre;
        this.institucion = institucion;
        this.nombreInstitucion = nombreInstitucion;
        this.fecha = fecha;
        this.logo = logo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
