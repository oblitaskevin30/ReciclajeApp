package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reciclaje")
public class Reciclaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String nombre;

    private int puntaje;

    public Reciclaje(){}

    public Reciclaje(int id, String nombre, int puntaje) {
        this.id = id;
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
