package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.serviceImpl;

import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.Usuario;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserDetailsService {

	@Autowired
	private UsuarioRepository dao;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = dao.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("El usuario con dicho email: " + email + " no existe."));

		return new UserDetailImplement(usuario);
	}
}