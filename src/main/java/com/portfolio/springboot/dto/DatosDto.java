package com.portfolio.springboot.dto;

import javax.validation.constraints.NotBlank;

public class DatosDto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String banner;
    @NotBlank
    private String imgPerfil;
    @NotBlank
    private String email;
    @NotBlank
    private String posicion;
    @NotBlank
    private String titulo;
    @NotBlank
    private String ubicacion;
    @NotBlank
    private String logo;
    @NotBlank
    private String linkedIn;
    @NotBlank
    private String github;


    public DatosDto() {
    }

    public DatosDto(String nombre, String banner, String imgPerfil, String email, String posicion, String titulo, String ubicacion, String logo, String linkedIn, String github) {
        this.nombre = nombre;
        this.banner = banner;
        this.imgPerfil = imgPerfil;
        this.email = email;
        this.posicion = posicion;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.logo = logo;
        this.linkedIn = linkedIn;
        this.github = github;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }
}
