package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.controller;

import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.dto.RegistroReciclajeProjection;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.RegistroReciclaje;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.service.RegistroReciclajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registro-reciclaje")
public class RegistroReciclajeController {

    @Autowired
    private RegistroReciclajeService registroReciclajeService;

    @PostMapping
    public ResponseEntity<?> crearRegistro(@RequestBody RegistroReciclaje registroReciclaje) {
        return registroReciclajeService.crearRegistroReciclaje(registroReciclaje);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarRegistrosReciclaje(){
        return  registroReciclajeService.listarRegistroReciclaje();
    }


    @GetMapping("/listar-detallado")
    public List<RegistroReciclajeProjection> listarDetallado() {
        return registroReciclajeService.obtenerRegistroConDetalles();
    }
}