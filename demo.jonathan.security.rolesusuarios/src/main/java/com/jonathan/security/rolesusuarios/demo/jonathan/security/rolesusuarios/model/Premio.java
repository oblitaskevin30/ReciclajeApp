package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model;

import jakarta.persistence.*;

@Entity
@Table(name = "premio")
public class Premio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Integer puntaje;

    public Premio(){}

    public Premio(Integer id, String nombre, Integer puntaje) {
        this.id = id;
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return "Premio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", puntaje=" + puntaje +
                '}';
    }
}
