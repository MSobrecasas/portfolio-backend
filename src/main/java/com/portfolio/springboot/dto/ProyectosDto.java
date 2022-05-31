package com.portfolio.springboot.dto;

import javax.validation.constraints.NotBlank;

public class ProyectosDto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String url;
    @NotBlank
    private String imagen;

    public ProyectosDto(String nombre, String descripcion, String url, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.imagen = imagen;
    }

    public ProyectosDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
