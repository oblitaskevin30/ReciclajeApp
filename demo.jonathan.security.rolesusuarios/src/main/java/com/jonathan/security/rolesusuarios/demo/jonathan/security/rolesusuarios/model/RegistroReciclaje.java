package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "registro_reciclaje")
public class RegistroReciclaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private int idUsuario;

    private int idMaterial;

    private int puntajeObtenido;

    private double cantidad;

    private LocalDateTime fecha;

    public RegistroReciclaje(){}

    public RegistroReciclaje(int id, int idUsuario, int idMaterial, int puntajeObtenido, LocalDateTime fecha, Double cantidad) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idMaterial = idMaterial;
        this.puntajeObtenido = puntajeObtenido;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public int getPuntajeObtenido() {
        return puntajeObtenido;
    }

    public void setPuntajeObtenido(int puntajeObtenido) {
        this.puntajeObtenido = puntajeObtenido;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}
