package com.btcc.institucional.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.btcc.institucional.dao.UsuarioDao;
import com.btcc.institucional.domain.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioDao.findByName(username);

		GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getPermissao());
		
		org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User (usuario.getNome(), usuario.getPassword(), Arrays.asList(authority));
		
		UserDetails userDatails = (UserDetails) user;
		
		return userDatails;
	}
	
	
}
