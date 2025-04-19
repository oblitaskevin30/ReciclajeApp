package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.service;

import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.Rol;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RolService {
    ResponseEntity<?> listarRoles();
    ResponseEntity<?> buscarRolporId(Integer id);
    ResponseEntity<?> crearRol(Rol rol);
    ResponseEntity<?> modificarRol(Integer id,Rol rol);
    ResponseEntity<?> eliminarRol(Integer id);

}
