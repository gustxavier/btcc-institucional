package com.btcc.institucional.web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.btcc.institucional.domain.Imagem;
import com.btcc.institucional.domain.ImagemLocal;
import com.btcc.institucional.domain.ImagemTipo;
import com.btcc.institucional.domain.Noticia;
import com.btcc.institucional.service.ImagemService;


@Controller
@RequestMapping("/admin/imagens")
public class ImagemController {
	
	@Autowired
	private ImagemService service;	
	
	@GetMapping("/cadastrar-home")
	public String cadastrar(Imagem imagem) {		
		return "admin/imagem/cadastro-home";
	}
	
	@GetMapping("/listar-home")
	public String listarHome(ModelMap model) {
		model.addAttribute("imagem", service.buscarTodos(ImagemTipo.home));
		return "/admin/imagem/lista-home";
	}
	
	@GetMapping("editar-home/{id}")
	public String preEditarHome(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("imagem", service.buscaPorId(id));
		return "admin/imagem/cadastro-home";
	}

	@PostMapping("/editar-home")
	public String editarHome(@RequestParam("file") MultipartFile file, Imagem imagem, RedirectAttributes attr) {
		if(file.isEmpty()) {
			attr.addFlashAttribute("warning", "Você precisa selecionar uma imagem");
			return "redirect:/admin/imagens/listar-home";
		}
		
		if(!service.removeFile(imagem.getId())) {
			attr.addFlashAttribute("fail", "Falha ao tentar editar a imagem");
			return "redirect:/admin/imagens/listar-home";
		}
		
		ArrayList<String> obj = service.uploadFile(file, imagem);
		attr.addFlashAttribute(obj.get(0), obj.get(1));
		return "redirect:/admin/imagens/listar-home";
	}
	
}