package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model;


public class UsuarioResponse {

    private String email;
    private String nombre;


    public UsuarioResponse(){}

    public UsuarioResponse(String email, String nombre) {
        this.email = email;

        this.nombre = nombre;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
