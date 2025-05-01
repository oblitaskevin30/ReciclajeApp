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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        registroReciclaje1.setFecha(LocalDateTime.now());
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

    @Override
    public ResponseEntity<?> actualizarRegistroReciclaje(Integer id, RegistroReciclaje registroReciclaje) {
        Optional<RegistroReciclaje> optionalRegistro = registroReciclajeRepository.findById(id);

        if (optionalRegistro.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro no encontrado con ID: " + id);
        }

        RegistroReciclaje registroExistente = optionalRegistro.get();

        // Actualizamos campos
        registroExistente.setFecha(LocalDateTime.now()); // actualiza la fecha al momento de la edición
        registroExistente.setIdUsuario(registroReciclaje.getIdUsuario());
        registroExistente.setIdMaterial(registroReciclaje.getIdMaterial());
        registroExistente.setCantidad(registroReciclaje.getCantidad());

        int puntajeMaterial = reciclajeRepository.findById(registroReciclaje.getIdMaterial())
                .orElseThrow().getPuntaje();

        registroExistente.setPuntajeObtenido((int)(puntajeMaterial * registroExistente.getCantidad()));

        registroReciclajeRepository.save(registroExistente);

        return ResponseEntity.ok(registroExistente);
    }


    @Override
    public ResponseEntity<?> eliminarRegistroReciclaje(Integer id) {
        Optional<RegistroReciclaje> optionalRegistro = registroReciclajeRepository.findById(id);

        if (optionalRegistro.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro no encontrado con ID: " + id);
        }

        registroReciclajeRepository.deleteById(id);

        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }


}
