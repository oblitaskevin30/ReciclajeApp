package com.jonathan.security.rolesusuarios.demo.jonathan.security.rolesusuarios.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Token {

	private final static String TOKEN_SECRETO = "6LwLwR4rmwxKydmPldFTiyKA4YmgsywZ";
	private final static Long TOKEN_DURACION = 1_000_000L;

	public static String crearToken(String nombre, String email) {
		long expiracionTiempo = TOKEN_DURACION * 1_000;
		Date expiracionFecha = new Date(System.currentTimeMillis() + expiracionTiempo);

		Map<String, Object> claims = new HashMap<>();
		claims.put("nombre", nombre);

		return Jwts.builder()
				.setSubject(email)
				.setExpiration(expiracionFecha)
				.addClaims(claims)
				.signWith(Keys.hmacShaKeyFor(TOKEN_SECRETO.getBytes()))
				.compact();
	}

	public static UsernamePasswordAuthenticationToken getAuth(String token) {
		try {
			Claims claims = Jwts.parserBuilder()
					.setSigningKey(TOKEN_SECRETO.getBytes())
					.build()
					.parseClaimsJws(token)
					.getBody();

			String email = claims.getSubject();

			return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
		} catch (JwtException e) {
			return null;
		}
	}
}