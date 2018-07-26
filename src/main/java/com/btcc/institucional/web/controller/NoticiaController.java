package com.btcc.institucional.web.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	
	@PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes attr) {

        if (file.isEmpty()) {
        	attr.addFlashAttribute("message", "Por favor insira uma imagem");
            return "redirect:/admin/noticias/cadastrar";
        }
        System.out.println("NHAE");
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get("/image/uploads/" + file.getOriginalFilename());
            Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/admin/noticias/salvar";
    }
	
	@PostMapping("/salvar")
	public String salvar(Noticia noticia, RedirectAttributes attr) {
		service.salvar(noticia);
		attr.addFlashAttribute("success", "Notícia inserida com sucesso");
		return "redirec:/admin/noticias/listar";
	}
	
	@ModelAttribute("data")
	public String data() {
		LocalDate localDate = LocalDate.now();
		return DateTimeFormatter.ofPattern("dd/MM/yyy").format(localDate);
	}
	
	@GetMapping("editar/{id}")
	public String preEditar(@PathVariable("id") BigInteger id, ModelMap model) {
		model.addAttribute("noticia", service.buscaPorId(id));
		return "admin/noticia/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Noticia noticia, RedirectAttributes attr) {
		service.editar(noticia);
		attr.addFlashAttribute("success","Notícia editado com sucesso.");
		return "redirect:/admin/noticias/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") BigInteger id, ModelMap model) {
		service.excluir(id);
			model.addAttribute("success", "Notícia excluído com sucesso.");
		return listar(model);
	}
	
	
}
