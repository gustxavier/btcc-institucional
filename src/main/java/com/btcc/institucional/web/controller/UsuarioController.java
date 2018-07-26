package com.btcc.institucional.web.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String salvar(Usuario usuario, RedirectAttributes attr) {
		service.salvar(usuario);
		attr.addFlashAttribute("success","Usuário inserido com sucesso.");
		return "redirect:/admin/usuarios/listar";
	}
	
	@GetMapping("editar/{id}")
	public String preEditar(@PathVariable("id") BigInteger id, ModelMap model) {
		model.addAttribute("usuario", service.buscaPorId(id));
		return "admin/usuario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Usuario usuario, RedirectAttributes attr) {
		service.editar(usuario);
		attr.addFlashAttribute("success","Usuário editado com sucesso.");
		return "redirect:/admin/usuarios/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") BigInteger id, ModelMap model) {
			service.excluir(id);
			model.addAttribute("success", "Usuário excluído com sucesso.");
		return listar(model);
	}
}
