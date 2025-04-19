package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.dto;

public class RegistroMaterialDTO {
    private int idMaterial;
    private String nombreMaterial;
    private int PuntajeAcumuladoMaterial;

    public RegistroMaterialDTO(){}

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public int getPuntajeAcumuladoMaterial() {
        return PuntajeAcumuladoMaterial;
    }

    public void setPuntajeAcumuladoMaterial(int puntajeAcumuladoMaterial) {
        PuntajeAcumuladoMaterial = puntajeAcumuladoMaterial;
    }
}
