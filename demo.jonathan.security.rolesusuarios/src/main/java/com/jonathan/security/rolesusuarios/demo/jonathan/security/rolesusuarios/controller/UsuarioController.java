package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.controller;

import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.Usuario;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.serviceImpl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping("/crear")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario){
        return usuarioService.crearUsuario(usuario);
    }

    @PostMapping("/crear/admin")
    public ResponseEntity<?> crearUsuarioAdmin(@RequestBody Usuario usuario){
        return usuarioService.crearUsuarioAdmin(usuario);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificarUsuario(@PathVariable Integer id,@RequestBody Usuario usuario){
        return usuarioService.modificarUsuario(id,usuario);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarUsuarios(){
        return  usuarioService.listarUsuario();
    }

    @GetMapping("/buscarPorEmail")
    public ResponseEntity<?> findByEmail(@RequestParam(name = "email") String email){
        return  usuarioService.buscarUsuarioResponsePorEmail(email);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        return  usuarioService.buscarUsuarioPorId(id);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Integer id){
        return  usuarioService.eliminarUsuario(id);
    }




}
