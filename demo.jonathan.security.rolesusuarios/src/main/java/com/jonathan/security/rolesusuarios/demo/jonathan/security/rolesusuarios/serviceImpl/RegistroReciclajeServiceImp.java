package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.serviceImpl;

import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.dto.RegistroReciclajeProjection;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.RegistroReciclaje;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.repository.ReciclajeRepository;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.repository.RegistroReciclajeRepository;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.service.RegistroReciclajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroReciclajeServiceImp implements RegistroReciclajeService {

    @Autowired
    RegistroReciclajeRepository registroReciclajeRepository;

    @Autowired
    ReciclajeRepository reciclajeRepository;

    @Override
    public ResponseEntity<?> listarRegistroReciclaje() {
        List<RegistroReciclaje> registroReciclajeList = registroReciclajeRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(registroReciclajeList);
    }

    @Override
    public ResponseEntity<?> crearRegistroReciclaje(RegistroReciclaje registroReciclaje) {

        RegistroReciclaje registroReciclaje1 = new RegistroReciclaje();
        registroReciclaje1.setFecha(registroReciclaje.getFecha());
        registroReciclaje1.setIdUsuario(registroReciclaje.getIdUsuario());
        registroReciclaje1.setIdMaterial(registroReciclaje.getIdMaterial());
        registroReciclaje1.setCantidad(registroReciclaje.getCantidad());

        int puntajeMaterial = reciclajeRepository.findById(registroReciclaje.getIdMaterial()).orElseThrow().getPuntaje();

        registroReciclaje1.setPuntajeObtenido((int)(puntajeMaterial * registroReciclaje1.getCantidad()));

        registroReciclajeRepository.save(registroReciclaje1);

        return ResponseEntity.status(HttpStatus.CREATED).body(registroReciclaje1);
    }

    public List<RegistroReciclajeProjection> obtenerRegistroConDetalles() {
        return registroReciclajeRepository.listarRegistroReciclajeCompleto();
    }

}
