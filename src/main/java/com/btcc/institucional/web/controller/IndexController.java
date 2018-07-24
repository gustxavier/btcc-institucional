package com.btcc.institucional.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

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
	public String noticias() {
		return "fragments/noticias";
	}
		
	@GetMapping("/contato")
	public String contato() {
		return "fragments/contato";
	}
	
	@GetMapping("/admin")
	public String adminHome() {
		return "admin/template";
	}
}
