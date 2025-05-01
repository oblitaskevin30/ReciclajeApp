package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.controller;

import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.Reciclaje;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.serviceImpl.ReciclajeServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reciclaje")
public class ReciclajeController {
    @Autowired
    private ReciclajeServiceimpl reciclajeServiceimpl;

    @GetMapping("/listar")
    public ResponseEntity<List<Reciclaje>> findAllReciclaje(){
        List<Reciclaje> reciclajes = reciclajeServiceimpl.findAllReciclaje();
        return ResponseEntity.status(HttpStatus.OK).body(reciclajes);
    }
}
