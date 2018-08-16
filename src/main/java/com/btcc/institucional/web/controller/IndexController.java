package com.btcc.institucional.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.btcc.institucional.domain.Usuario;
import com.btcc.institucional.service.NoticiaService;
import com.btcc.institucional.service.UsuarioService;

//http://www.mkyong.com/spring-boot/spring-boot-spring-security-thymeleaf-example/

@Controller
public class IndexController {

	@Autowired
	private NoticiaService noticiasService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/")
	public String index(ModelMap model) {
		model.addAttribute("activeTab","home");
		return "fragments/index";
	}
	
	@GetMapping("/empresa")
	public String empresa(ModelMap model) {
		model.addAttribute("activeTab","empresa");
		return "fragments/empresa";
	}
	
	@GetMapping("/premios")
	public String premios(ModelMap model) {	 
		model.addAttribute("activeTab","premios");
		return "fragments/premios";
	}
	
	@GetMapping("/noticias")
	public String noticias(ModelMap model) {
		model.addAttribute("activeTab","noticias");
		model.addAttribute("noticia", noticiasService.buscarTodos());
		return "fragments/noticias";
	}
	
	@GetMapping("/noticias/{id}/{titulo}")
	public String noticiasVisualizar(@PathVariable("id") Long id, @PathVariable("titulo") String titulo, ModelMap model) {
		model.addAttribute("activeTab","noticias");
		model.addAttribute("noticia", noticiasService.buscaPorId(id));
		return "fragments/single-post";
	}
		
	@GetMapping("/contato")
	public String contato(ModelMap model) {
		model.addAttribute("activeTab","contato");
		return "fragments/contato";
	}
	
	@GetMapping("/admin")
	public String adminDashboard(Usuario usuario) {
		usuarioService.loginTemUsuario(usuario);
		return "admin/template";
	}

    @GetMapping("/panel")
    public String userIndex() {
        return "admin/template";
    }
	
    @GetMapping("/login")
    public String login(Usuario usuario) {
        return "login";
    }
    
    @PostMapping("/login/entrar")
    public String loginEntrar(Usuario usuario ) {
    	String redirect = usuarioService.loginTemUsuario(usuario);
        return "redirect:" + redirect ;
    }
    
    @GetMapping("/login/error")
    public String loginErro(RedirectAttributes attr) {
    	attr.addFlashAttribute("warning", "Usuário ou senha inválido");
    	return "redirect:/login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }
    
    @GetMapping("/not-found")
    public String notFound() {
    	return "not-found";
    }
    
    @GetMapping("/popup")
    public String popup(ModelMap model) {
    	model.addAttribute("activeTab","premios");
        return "fragments/popup";
    }
}
