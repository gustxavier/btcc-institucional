package com.btcc.institucional.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/noticias")
public class NoticiaController {
	@GetMapping("/cadastrar")
	public String cadastrar() {
		return "/noticia/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "/noticia/lista";
	}
}
