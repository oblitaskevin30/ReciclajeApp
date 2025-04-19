package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.serviceImpl;

import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.Rol;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.repository.RolRepository;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository repository;


    @Override
    public ResponseEntity<?> listarRoles() {
        List<Rol> roles = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(roles);
    }

    @Override
    public ResponseEntity<?> buscarRolporId(Integer id) {
        Optional<Rol> rol = repository.findById(id);
        if(rol.isEmpty()){
            return ResponseEntity.badRequest().body("no se encuentra el rol con el id indicado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(rol.get());
    }

    @Override
    public ResponseEntity<?> crearRol(Rol rol) {
        return null;
    }

    @Override
    public ResponseEntity<?> modificarRol(Integer id, Rol rol) {
        return null;
    }

    @Override
    public ResponseEntity<?> eliminarRol(Integer id) {
        return null;
    }
}
