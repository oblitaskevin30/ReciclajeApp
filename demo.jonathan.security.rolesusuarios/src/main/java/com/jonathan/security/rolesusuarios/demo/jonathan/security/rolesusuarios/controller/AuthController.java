package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.controller;


import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.Usuario;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.UsuarioRequest;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UsuarioRequest usuarioRequest) {
        Map<String, Object> respuesta = new HashMap<>();
        try {
                if (usuarioRequest != null) {

                    Usuario usuario = new Usuario();
                    usuario.setEmail(usuarioRequest.getEmail());
                    usuario.setPassword(passwordEncoder.encode(usuarioRequest.getPassword()));
                    usuario.setNombre(usuarioRequest.getNombre());
                    return usuarioService.crearUsuario(usuario);
                }

                respuesta.put("mensaje", "El cuerpo de la solicitud está vacío");
                respuesta.put("timestamp", new Date());
                respuesta.put("estado", HttpStatus.BAD_REQUEST);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);

        } catch (Exception e) {
            respuesta.put("mensaje", "Error al crear el usuario");
            respuesta.put("error", e.getMessage());
            respuesta.put("timestamp", new Date());
            respuesta.put("estado", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> login() {
        // Este método no necesita lógica adicional porque el filtro JWTAuthenticationFilter
        // ahora maneja la respuesta del login exitoso.
        Map<String, Object> error = new HashMap<>();
        error.put("mensaje", "Usuario no autenticado");
        error.put("timestamp", new Date());
        error.put("estado", HttpStatus.UNAUTHORIZED);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }



}