package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.service;

import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.Premio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PremioService {
    List<Premio> findAllPremios();
}
