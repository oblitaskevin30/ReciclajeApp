package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.dto;

public interface RegistroReciclajeProjection {
    Integer getIdRegistro();
    Integer getIdUsuario();
    String getNombreUsuario();
    Integer getIdMaterial();
    String getNombreMaterial();
    Integer getPuntajeMaterial();
    Integer getCantidad();
    Integer getPuntajeObtenido();
    String getFecha(); //
}
