package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.serviceImpl;

import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.Premio;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.repository.PremioRepository;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.service.PremioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremioServiceImpl implements PremioService {
    @Autowired
    private PremioRepository premioRepository;

    @Override
    public List<Premio> findAllPremios() {
        return premioRepository.findAll();
    }

}
