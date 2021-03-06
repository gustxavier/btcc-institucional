package com.btcc.institucional.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.btcc.institucional.domain.NoticiaCategoria;
import com.btcc.institucional.domain.NoticiaImagem;
import com.btcc.institucional.domain.NoticiaVideo;
import com.btcc.institucional.service.NoticiaCategoriaService;
import com.btcc.institucional.service.NoticiaImagemService;
import com.btcc.institucional.service.NoticiaService;
import com.btcc.institucional.service.NoticiaVideoService;

@Controller
@RequestMapping("/admin/noticias")
public class NoticiaController {

	@Value("${btcc.siteUrl}")
	private String siteUrl;

	@Autowired
	private NoticiaService service;

	@Autowired
	private NoticiaImagemService serviceImagem;

	@Autowired
	private NoticiaVideoService serviceVideo;

	@Autowired
	private NoticiaCategoriaService serviceCategoria;

	@GetMapping("/cadastrar")
	public String cadastrar(Noticia noticia) {
		return "admin/noticia/cadastro";
	}

	@GetMapping("/cadastrar-imagem")
	public String cadastrarImagem(NoticiaImagem noticiaImagem) {
		return "admin/noticia/cadastro-imagem";
	}

	@GetMapping("/cadastrar-video")
	public String cadastrarVideo(NoticiaVideo noticiaVideo) {
		return "admin/noticia/cadastro-video";
	}

	@GetMapping("/cadastrar-categoria")
	public String cadastrarCategoria(NoticiaCategoria noticiaCategoria) {
		return "admin/noticia/cadastro-categoria";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("noticia", service.buscarTodos());
		return "admin/noticia/lista";
	}

	@GetMapping("/listar-imagens")
	public String listarImagem(ModelMap model) {
		model.addAttribute("imagem", serviceImagem.buscarTodos());
		return "admin/noticia/lista-imagem";
	}


	@GetMapping("/listar-videos")
	public String listarVideo(ModelMap model) {
		model.addAttribute("video", serviceVideo.buscarTodos());
		return "admin/noticia/lista-video";
	}

	@GetMapping("/listar-categoria")
	public String listarCategoria(ModelMap model) {
		model.addAttribute("noticiaCategoria", serviceCategoria.buscarTodos());
		return "admin/noticia/lista-categoria";
	}

	@PostMapping("/salvar")
	public String salvar(@RequestParam("file") MultipartFile file, Noticia noticia, RedirectAttributes attr) {
		if(!service.validaFomulario(noticia)) {
			attr.addFlashAttribute("warning", "Todos os campos devem ser preenchidos");
			return "redirect:/admin/noticias/cadastrar";
		}
		ArrayList<String> obj = service.uploadFile(file, noticia);
		service.salvar(noticia);
		attr.addFlashAttribute(obj.get(0), obj.get(1));
		return "redirect:/admin/noticias/listar";
	}

	@PostMapping("/salvar-imagem")
	public String salvarImagem(@RequestParam("file") MultipartFile file, NoticiaImagem noticiaImagem, RedirectAttributes attr) {
		ArrayList<String> obj = serviceImagem.uploadFile(file, noticiaImagem);
		serviceImagem.salvar(noticiaImagem);
		attr.addFlashAttribute(obj.get(0), obj.get(1));
		return "redirect:/admin/noticias/listar-imagens";
	}

	@PostMapping("/salvar-video")
	public String salvarVideo(@RequestParam("file") MultipartFile file, NoticiaVideo noticiaVideo, RedirectAttributes attr) {
		ArrayList<String> obj = serviceVideo.uploadFile(file, noticiaVideo);
		serviceVideo.salvar(noticiaVideo);
		attr.addFlashAttribute(obj.get(0), obj.get(1));
		return "redirect:/admin/noticias/listar-videos";
	}

	@PostMapping("/salvar-categoria")
	public String salvar(NoticiaCategoria noticiaCategoria, RedirectAttributes attr) {
		if(noticiaCategoria.getNome().isEmpty()) {
			attr.addFlashAttribute("warning", "Você precisa inserir um nome!");
			return "redirect:/admin/noticias/cadastrar-categoria";
		}
		serviceCategoria.salvar(noticiaCategoria);
		attr.addFlashAttribute("success", "Categoria adicionada com sucesso!");
		return "redirect:/admin/noticias/listar-categoria";
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

	@GetMapping("/editar-categoria/{id}")
	public String preEditarCategoria(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("noticiaCategoria", serviceCategoria.buscaPorId(id));
		return "admin/noticia/cadastro-categoria"; 
	}

	@PostMapping("/editar-categoria")
	public String editarCategoria(NoticiaCategoria noticiaCategoria, RedirectAttributes attr) {
		if(noticiaCategoria.getNome().isEmpty()) {
			attr.addFlashAttribute("warning", "Você precisa inserir o nome da categoria.");
		}else {
			serviceCategoria.editar(noticiaCategoria);
			attr.addFlashAttribute("success", "Categoria editada com sucesso.");
		}
		return "redirect:/admin/noticias/listar-categoria";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		if (!service.removeFile(id)) {
			attr.addFlashAttribute("fail", "Falhar ao excluir a notícia!");
			return "redirect:/admin/noticias/listar";
		}
		service.excluir(id);
		attr.addFlashAttribute("success", "Notícia excluída com sucesso!");
		return "redirect:/admin/noticias/listar";
	}

	@GetMapping("/excluir-categoria/{id}")
	public String excluirCategoria(@PathVariable("id") Long id, RedirectAttributes attr) {
		if(serviceCategoria.categoriaTemNoticia(id)) {
			attr.addFlashAttribute("fail", "Categoria não excluída. Existem notícias com esta categoria!");
		}else {
			serviceCategoria.excluir(id);
			attr.addFlashAttribute("success", "Categoria excluída com sucesso!");
		}
		return "redirect:/admin/noticias/listar-categoria";
	}

	@GetMapping("/excluir-imagem/{id}")
	public String excluirImagem(@PathVariable("id") Long id, RedirectAttributes attr) {
		if (!serviceImagem.removeFile(id)) {
			attr.addFlashAttribute("fail", "Falhar ao excluir a imagem!");
			return "redirect:/admin/noticias/listar-imagens";
		}
		serviceImagem.excluir(id);
		attr.addFlashAttribute("success", "Imagem excluída com sucesso!");
		return "redirect:/admin/noticias/listar-imagens";
	}

	@GetMapping("/excluir-video/{id}")
	public String excluirVideo(@PathVariable("id") Long id, RedirectAttributes attr) {
		if (!serviceVideo.removeFile(id)) {
			attr.addFlashAttribute("fail", "Falhar ao excluir o vídeo!");
			return "redirect:/admin/noticias/listar-videos";
		}
		serviceVideo.excluir(id);
		attr.addFlashAttribute("success", "Vídeo excluído com sucesso!");
		return "redirect:/admin/noticias/listar-videos";
	}

	@ModelAttribute("link")
	public String linkBase() {
		return siteUrl;
	}

	@ModelAttribute("categorias")
	public List<NoticiaCategoria> listaCategorias(){
		return serviceCategoria.buscarTodos();
	}


}
