package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.controller;

import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.Premio;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.service.PremioService;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.serviceImpl.PremioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/premio")
public class PremioController {

    @Autowired
    private PremioServiceImpl premioService;

    @RequestMapping
    public ResponseEntity<List<Premio>> findAllPremios(){
        List<Premio> premios = premioService.findAllPremios();
        return  ResponseEntity.status(HttpStatus.OK).body(premios);
    }





}
