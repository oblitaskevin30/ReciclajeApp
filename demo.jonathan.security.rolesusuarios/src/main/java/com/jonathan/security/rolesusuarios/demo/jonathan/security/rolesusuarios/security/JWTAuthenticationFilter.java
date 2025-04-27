package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.Auth;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.Usuario;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.model.UsuarioResponse;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.repository.UsuarioRepository;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.serviceImpl.UserDetailImplement;
import com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.utils.Token;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		Auth authCredenciales;
		try {
			authCredenciales = new ObjectMapper().readValue(request.getReader(), Auth.class);
		} catch (IOException e) {
			throw new RuntimeException("Error al leer las credenciales de autenticación");
		}

		UsernamePasswordAuthenticationToken userPAT = new UsernamePasswordAuthenticationToken(
				authCredenciales.getEmail(),
				authCredenciales.getPassword(),
				Collections.emptyList()
		);

		return getAuthenticationManager().authenticate(userPAT);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
											Authentication authResult) throws IOException, ServletException {

		UserDetailImplement userDetails = (UserDetailImplement) authResult.getPrincipal();
		String token = Token.crearToken(userDetails.getUser(), userDetails.getUsername());
		UsuarioResponse usuarioResponse = new UsuarioResponse();
		usuarioResponse.setEmail(userDetails.getUsername());
		usuarioResponse.setNombre(userDetails.getUser());


		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put("token", token);
		responseBody.put("usuario", usuarioResponse);


		response.setContentType("application/json");
		response.getWriter().write(new ObjectMapper().writeValueAsString(responseBody));
		response.getWriter().flush();


		SecurityContextHolder.getContext().setAuthentication(authResult);
	}

}