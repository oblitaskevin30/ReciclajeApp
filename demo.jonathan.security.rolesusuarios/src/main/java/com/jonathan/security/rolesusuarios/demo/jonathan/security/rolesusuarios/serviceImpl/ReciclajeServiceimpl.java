package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.serviceImpl;

import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.Reciclaje;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.repository.ReciclajeRepository;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.service.ReciclajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReciclajeServiceimpl implements ReciclajeService {

    @Autowired
    private ReciclajeRepository reciclajeRepository;

    @Override
    public List<Reciclaje> findAllReciclaje() {
        return reciclajeRepository.findAll();
    }
}
