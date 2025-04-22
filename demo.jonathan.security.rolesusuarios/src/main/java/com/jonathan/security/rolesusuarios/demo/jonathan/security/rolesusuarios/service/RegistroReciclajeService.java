package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.service;


import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.dto.RegistroReciclajeProjection;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.RegistroReciclaje;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RegistroReciclajeService {

    ResponseEntity<?> listarRegistroReciclaje();
    ResponseEntity<?> crearRegistroReciclaje(RegistroReciclaje registroReciclaje);
    List<RegistroReciclajeProjection> obtenerRegistroConDetalles();

}
