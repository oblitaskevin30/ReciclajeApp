package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.controller;

import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.RegistroReciclaje;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.service.RegistroReciclajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registro-reciclaje")
public class RegistroReciclajeController {

    @Autowired
    private RegistroReciclajeService registroReciclajeService;

    @PostMapping
    public ResponseEntity<?> crearRegistro(@RequestBody RegistroReciclaje registroReciclaje) {
        return registroReciclajeService.crearRegistroReciclaje(registroReciclaje);
    }
}