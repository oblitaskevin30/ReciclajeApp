package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private Integer id;

    @Column(name = "rolname")
    private String rolname;

    public Rol(){}

    public Rol(Integer id, String rolname) {
        this.id = id;
        this.rolname = rolname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolname() {
        return rolname;
    }

    public void setRolname(String rolname) {
        this.rolname = rolname;
    }
}
