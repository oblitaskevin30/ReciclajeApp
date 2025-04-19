package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.repository;

import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.RegistroReciclaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroReciclajeRepository extends JpaRepository<RegistroReciclaje, Integer> {
}
