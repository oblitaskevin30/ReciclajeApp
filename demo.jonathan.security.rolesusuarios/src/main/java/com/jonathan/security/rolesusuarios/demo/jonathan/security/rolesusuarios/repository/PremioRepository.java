package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.repository;

import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.Premio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremioRepository extends JpaRepository<Premio, Integer> {
}
