package com.btcc.institucional.web.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.btcc.institucional.config.SecurityConfig;
import com.btcc.institucional.domain.Noticia;
import com.btcc.institucional.domain.NoticiaCategoria;
import com.btcc.institucional.service.NoticiaService;

@Controller
public class IndexController {
	
	@Autowired
	private NoticiaService noticiasService;
	
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
		Noticia noticia = noticiasService.buscaPorId(id);
		model.addAttribute("activeTab","noticias");
		model.addAttribute("noticia", noticia);
		model.addAttribute("relacionadas", noticiasService.buscarRelacionadas(id, noticia.getCategoria().getId()));
		return "fragments/single-post";
	}
		
	@GetMapping("/contato")
	public String contato(ModelMap model) {
		model.addAttribute("activeTab","contato");
		return "fragments/contato";
	}
	
	@GetMapping("/admin/panel")
	public String adminDashboard() {
		return "admin/template";
	}

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "forward:/login?logout";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }
        
    @GetMapping("/popup")
    public String popup(ModelMap model) {
    	model.addAttribute("activeTab","premios");
        return "fragments/popup";
    }
}
