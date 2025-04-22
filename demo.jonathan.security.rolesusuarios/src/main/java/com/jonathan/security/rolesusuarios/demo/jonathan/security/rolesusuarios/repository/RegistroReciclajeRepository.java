package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.repository;

import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.dto.RegistroReciclajeProjection;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.RegistroReciclaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroReciclajeRepository extends JpaRepository<RegistroReciclaje, Integer> {

    @Query(value = """
        SELECT 
            rr.id as idRegistro,
            rr.idusuario as idUsuario,
            u.nombre as nombreUsuario,
            rr.idmaterial as idMaterial,
            r.nombre as nombreMaterial,
            r.puntaje as puntajeMaterial,
            rr.cantidad,
            rr.puntajeobtenido,
            rr.fecha
        FROM registro_reciclaje rr
        INNER JOIN usuario u ON u.idusuario = rr.idusuario
        INNER JOIN reciclaje r ON r.id = rr.idmaterial
        """, nativeQuery = true)
    List<RegistroReciclajeProjection> listarRegistroReciclajeCompleto();
}
