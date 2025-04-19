package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.serviceImpl;

import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.dto.RegistroMaterialDTO;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.dto.UsuarioDTO;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.Reciclaje;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.RegistroReciclaje;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.Rol;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.Usuario;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.repository.ReciclajeRepository;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.repository.RegistroReciclajeRepository;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.repository.RolRepository;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.repository.UsuarioRepository;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private RegistroReciclajeRepository registroReciclajeRepository;

    @Autowired
    private ReciclajeRepository reciclajeRepository;

    @Override
    public ResponseEntity<?> listarUsuario() {
        Map<String, Object> respuesta = new HashMap<>();
        List<Usuario> usuarios = usuarioRepository.findAll();

        if (usuarios.isEmpty()) {
            respuesta.put("mensaje", "No hay usuarios registrados en este momento");
            respuesta.put("timestamp", new Date());
            respuesta.put("estado", HttpStatus.BAD_REQUEST);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
        }

        List<UsuarioDTO> usuarioDTOList = usuarios.stream().map(usuario -> {
            UsuarioDTO dto = usuario.getUsuarioDTO();


            List<RegistroReciclaje> registros = registroReciclajeRepository
                    .findAll()
                    .stream()
                    .filter(r -> r.getIdUsuario() == usuario.getIdUsuario())
                    .toList();


            Map<Integer, RegistroMaterialDTO> materialesMap = new HashMap<>();

            for (RegistroReciclaje registro : registros) {
                int idMaterial = registro.getIdMaterial();
                Reciclaje reciclaje = reciclajeRepository.findById(idMaterial).orElse(null);

                if (reciclaje != null) {
                    materialesMap.compute(idMaterial, (id, existing) -> {
                        if (existing == null) {
                            RegistroMaterialDTO nuevo = new RegistroMaterialDTO();
                            nuevo.setIdMaterial(idMaterial);
                            nuevo.setNombreMaterial(reciclaje.getNombre());
                            nuevo.setPuntajeAcumuladoMaterial(registro.getPuntajeObtenido());
                            return nuevo;
                        } else {
                            existing.setPuntajeAcumuladoMaterial(
                                    existing.getPuntajeAcumuladoMaterial() + registro.getPuntajeObtenido()
                            );
                            return existing;
                        }
                    });
                }
            }

            dto.setMaterialesReciclados(new HashSet<>(materialesMap.values()));
            return dto;
        }).toList();

        respuesta.put("mensaje", "Lista de usuarios");
        respuesta.put("timestamp", new Date());
        respuesta.put("data", usuarioDTOList);
        respuesta.put("estado", HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }



    @Override
    public ResponseEntity<?> buscarUsuarioPorId(Integer id) {
        Map<String, Object> respuesta = new HashMap<>();
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();

            List<RegistroReciclaje> registros = registroReciclajeRepository
                    .findAll()
                    .stream()
                    .filter(r -> r.getIdUsuario() == usuario.getIdUsuario())
                    .toList();

            UsuarioDTO dto = usuario.getUsuarioDTO();
            Map<Integer, RegistroMaterialDTO> materialesMap = new HashMap<>();

            for (RegistroReciclaje registro : registros) {
                int idMaterial = registro.getIdMaterial();
                Reciclaje reciclaje = reciclajeRepository.findById(idMaterial).orElse(null);

                if (reciclaje != null) {
                    materialesMap.compute(idMaterial, (idMat, existing) -> {
                        if (existing == null) {
                            RegistroMaterialDTO nuevo = new RegistroMaterialDTO();
                            nuevo.setIdMaterial(idMaterial);
                            nuevo.setNombreMaterial(reciclaje.getNombre());
                            nuevo.setPuntajeAcumuladoMaterial(registro.getPuntajeObtenido());
                            return nuevo;
                        } else {
                            existing.setPuntajeAcumuladoMaterial(
                                    existing.getPuntajeAcumuladoMaterial() + registro.getPuntajeObtenido()
                            );
                            return existing;
                        }
                    });
                }
            }

            dto.setMaterialesReciclados(new HashSet<>(materialesMap.values()));

            respuesta.put("mensaje", "Usuario encontrado exitosamente");
            respuesta.put("timestamp", new Date());
            respuesta.put("data", dto);
            respuesta.put("estado", HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.OK).body(respuesta);
        }

        respuesta.put("mensaje", "No hay usuario registrado con ese id");
        respuesta.put("timestamp", new Date());
        respuesta.put("estado", HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
    }

    @Override
    public ResponseEntity<?> crearUsuario(Usuario usuario) {
        Map<String , Object> respuesta = new HashMap<>();
        if(usuario != null){
            Usuario newUsuario = new Usuario();
            newUsuario.setEmail(usuario.getEmail());
            newUsuario.setPassword(usuario.getPassword());
            newUsuario.setNombre(usuario.getNombre());
            newUsuario.setRoles(new HashSet<>());


            // llamo primero al rol que quiero asignar ===>  clientes con id 2
            Rol rol = rolRepository.findById(2).orElseThrow();

            newUsuario.getRoles().add(rol);

            usuarioRepository.save(newUsuario);

            respuesta.put("mensaje", "usuario CLIENTE creado correctamente");
            respuesta.put("timestamp", new Date());
            respuesta.put("data", newUsuario);
            respuesta.put("estado", HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.OK).body(respuesta);

        }
        respuesta.put("mensaje", "error al crear el usuario");
        respuesta.put("timestamp", new Date());
        respuesta.put("estado", HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
    }




    @Override
    public ResponseEntity<?> modificarUsuario(Integer id, Usuario usuario) {
        Map<String , Object> respuesta = new HashMap<>();
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){
            Usuario usuarioAModificar = usuarioOptional.get();
            usuarioAModificar.setEmail(usuario.getEmail());
            usuarioAModificar.setPassword(usuario.getPassword());
            usuarioAModificar.setNombre(usuario.getNombre());
            usuarioRepository.save(usuarioAModificar);

            respuesta.put("mensaje", "usuario modificado correctamente");
            respuesta.put("timestamp", new Date());
            respuesta.put("data", usuarioAModificar);
            respuesta.put("estado", HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.OK).body(respuesta);

        }

        respuesta.put("mensaje", "error al modificar el usuario");
        respuesta.put("timestamp", new Date());
        respuesta.put("estado", HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
    }

    @Override
    public ResponseEntity<?> eliminarUsuario(Integer id) {
        Map<String , Object> respuesta = new HashMap<>();
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if(usuarioOptional.isPresent()){

            Usuario usuario =  usuarioOptional.get();
            usuario.getRoles().size();
            respuesta.put("mensaje", "usuario eliminado correctamente");
            respuesta.put("timestamp", new Date());
            respuesta.put("data", usuario );
            respuesta.put("estado", HttpStatus.OK);
            usuarioRepository.delete(usuario);

            return ResponseEntity.status(HttpStatus.OK).body(respuesta);

        }

        respuesta.put("mensaje", "error al eliminar el usuario");
        respuesta.put("timestamp", new Date());
        respuesta.put("estado", HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
    }

    @Override
    public ResponseEntity<?> crearUsuarioAdmin(Usuario usuario) {
        Map<String , Object> respuesta = new HashMap<>();
        if(usuario != null){
            Usuario newUsuario = new Usuario();
            newUsuario.setEmail(usuario.getEmail());
            newUsuario.setPassword(usuario.getPassword());
            newUsuario.setNombre(usuario.getNombre());


            newUsuario.setRoles(new HashSet<>());

            Rol rol = rolRepository.findById(1).orElseThrow();

            newUsuario.getRoles().add(rol);
            usuarioRepository.save(newUsuario);

            respuesta.put("mensaje", "usuario creado UN USUARIO ADMIN correctamente");
            respuesta.put("timestamp", new Date());
            respuesta.put("data", newUsuario);
            respuesta.put("estado", HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.OK).body(respuesta);

        }
        respuesta.put("mensaje", "error al crear el usuario");
        respuesta.put("timestamp", new Date());
        respuesta.put("estado", HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
    }
}
