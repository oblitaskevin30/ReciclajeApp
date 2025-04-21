package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.dto;


import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.Rol;
import jakarta.persistence.Column;

import java.util.Set;

public class UsuarioDTO {

    private Integer idUsuario;

    @Column(unique = true)
    private String email;

    private String nombre;

    private Set<Rol> roles;

    private Set<RegistroMaterialDTO> materialesReciclados;

    private Integer puntajeTotal;

    public UsuarioDTO(){}

    public UsuarioDTO(Integer idUsuario, String email ,String nombre,Set<RegistroMaterialDTO> materialesReciclados,  Set<Rol> roles, Integer puntajeTotal) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.roles = roles;
        this.nombre = nombre;
        this.materialesReciclados = materialesReciclados;
        this.puntajeTotal = puntajeTotal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RegistroMaterialDTO> getMaterialesReciclados() {
        return materialesReciclados;
    }

    public void setMaterialesReciclados(Set<RegistroMaterialDTO> materialesReciclados) {
        this.materialesReciclados = materialesReciclados;
    }

    public Integer getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(Integer puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }
}
