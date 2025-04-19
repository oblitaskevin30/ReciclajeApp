package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.dto.RegistroMaterialDTO;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.dto.UsuarioDTO;
import jakarta.persistence.*;


import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer idUsuario;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST}

    )
    @JoinTable(
            name = "usuario_rol",
            joinColumns = @JoinColumn(name = "idusuario"),
            inverseJoinColumns = @JoinColumn(name = "idrol")
    )
    private Set<Rol> roles;

    @Transient
    private Set<RegistroMaterialDTO> materialesReciclados;

    public Usuario(){}

    public Usuario(Integer idUsuario, String email, String password, String nombre, Set<Rol> roles) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.nombre = nombre;
    }

    @JsonIgnore
    public UsuarioDTO getUsuarioDTO(){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdUsuario(idUsuario);
        usuarioDTO.setEmail(email);
        usuarioDTO.setRoles(roles);
        usuarioDTO.setNombre(nombre);
        usuarioDTO.setMaterialesReciclados(materialesReciclados);
        return  usuarioDTO;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}



