package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.service;

import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.Usuario;
import org.springframework.http.ResponseEntity;

public interface UsuarioService {
    ResponseEntity<?> listarUsuario();
    ResponseEntity<?> buscarUsuarioPorId(Integer id);
    ResponseEntity<?> crearUsuario(Usuario usuario);
    ResponseEntity<?> modificarUsuario(Integer id,Usuario usuario);
    ResponseEntity<?> eliminarUsuario(Integer id);
    ResponseEntity<?> crearUsuarioAdmin(Usuario usuario);
    public ResponseEntity<?> buscarUsuarioResponsePorId(Integer id);
    public ResponseEntity<?> buscarUsuarioResponsePorEmail(String email);
}
