package com.btcc.institucional.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@GetMapping("/cadastrar")
	public String cadastrar() {
		return "/usuario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "/usuario/lista";
	}
}
