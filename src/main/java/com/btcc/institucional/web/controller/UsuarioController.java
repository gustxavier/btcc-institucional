package com.btcc.institucional.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.btcc.institucional.domain.Usuario;
import com.btcc.institucional.service.UsuarioService;

@Controller
@RequestMapping("/admin/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Usuario usuario) {
		return "admin/usuario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("usuario", service.buscarTodos());
		return "admin/usuario/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Usuario usuario) {
		service.salvar(usuario);
		return "redirect:/admin/usuario/cadatro";
	}
}
