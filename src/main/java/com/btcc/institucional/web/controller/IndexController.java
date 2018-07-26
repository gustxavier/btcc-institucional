package com.btcc.institucional.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.btcc.institucional.service.NoticiaService;
import com.btcc.institucional.domain.Noticia;

@Controller
public class IndexController {

	@Autowired
	private NoticiaService noticiasService;
	
	@GetMapping("/")
	public String index() {
		return "fragments/index";
	}
	
	@GetMapping("/empresa")
	public String empresa() {
		return "fragments/empresa";
	}
	
	@GetMapping("/premios")
	public String premios() {
		return "fragments/premios";
	}

	@GetMapping("/noticias")
	public String noticias(ModelMap model) {
		model.addAttribute("primeiranoticia", noticiasService.buscarPrimeiro());
		return "fragments/noticias";
	}
		
	@GetMapping("/contato")
	public String contato() {
		return "fragments/contato";
	}
	
	@GetMapping("/admin123")
	public String adminHome() {
		return "admin/template";
	}
}
