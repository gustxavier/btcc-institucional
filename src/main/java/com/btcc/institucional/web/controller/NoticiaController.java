package com.btcc.institucional.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/noticias")
public class NoticiaController {
	@GetMapping("/cadastrar")
	public String cadastrar() {
		return "/admin/noticia/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "/admin/noticia/lista";
	}
}
