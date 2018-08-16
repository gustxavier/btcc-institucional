package com.btcc.institucional.web.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.btcc.institucional.domain.Noticia;
import com.btcc.institucional.service.NoticiaService;

@Controller
@RequestMapping("/admin/noticias")
public class NoticiaController {

	@Autowired
	private NoticiaService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Noticia noticia) {
		return "admin/noticia/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("noticia", service.buscarTodos());
		return "admin/noticia/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@RequestParam("file") MultipartFile file, Noticia noticia, RedirectAttributes attr) {
		ArrayList<String> obj = service.uploadFile(file, noticia);
		service.salvar(noticia);
		attr.addFlashAttribute(obj.get(0), obj.get(1));
		return "redirect:/admin/noticias/listar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("noticia", service.buscaPorId(id));
		return "admin/noticia/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@RequestParam("file") MultipartFile file, Noticia noticia, RedirectAttributes attr) {
		if (!noticia.getImagem().isEmpty() && !file.isEmpty()) {
			if (!service.removeFile(noticia.getId())) {
				attr.addFlashAttribute("fail", "Falha ao tentar editar a notícia");
				return "redirect:/admin/noticias/listar";
			}
		}
		ArrayList<String> obj = service.uploadFile(file, noticia);
		service.editar(noticia);
		attr.addFlashAttribute(obj.get(0), obj.get(1));
		return "redirect:/admin/noticias/listar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		if (!service.removeFile(id)) {
			attr.addFlashAttribute("fail", "Falhar ao excluir a notícia!");
			return "redirect:/admin/noticias/listar";
		}
		System.out.println("oi oi");
		service.excluir(id);
		attr.addFlashAttribute("success", "Notícia excluída com sucesso!");
		return "redirect:/admin/noticias/listar";
	}

	@ModelAttribute("data")
	public String data() {
		LocalDate localDate = LocalDate.now();
		return DateTimeFormatter.ofPattern("dd/MM/yyy").format(localDate);
	}

}
