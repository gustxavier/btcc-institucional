package com.btcc.institucional.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.btcc.institucional.config.SecurityConfig;
import com.btcc.institucional.dao.NoticiaDao;
import com.btcc.institucional.domain.Noticia;

@Service @Transactional(readOnly = false)
public class NoticiaServiceImpl extends AbstractService implements NoticiaService{

	@Value("${btcc.filesPathUpload}")
    private String filesPath;

	@Autowired
	private NoticiaDao dao;

	private String filename;

	@Override
	public void salvar(Noticia noticia) {
		noticia.setLinkpermanente(noticia.getTitulo().replaceAll(" ", "-").toLowerCase());
		dao.save(noticia);
	}

	@Override
	public void editar(Noticia noticia) {
		noticia.setLinkpermanente(noticia.getTitulo().replaceAll(" ", "-").toLowerCase());
		dao.update(noticia);
	}

	@Override
	public void excluir (Long id) {
		dao.delete(id);		
	}

	@Override @Transactional(readOnly = true)
	public Noticia buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Noticia> buscarTodos() {
		return dao.findAll();
	}

	@Override @Transactional(readOnly = true)
	public List<Noticia> buscarPrimeiro() {
		return dao.findFirst();
	}

	@Override @Transactional(readOnly = true)
	public List<Noticia> buscarBlocoTresNoticias() {
		return dao.findFirst();
	}
	
	@Override @Transactional(readOnly = true)
	public List<Noticia> buscarRelacionadas(Long noticiaId, Long categoriaId) {
		return dao.findRelated(noticiaId, categoriaId);
	}
	

	@Override
	public ArrayList<String> uploadFile (MultipartFile file, Noticia noticia) {

		ArrayList<String> obj = new ArrayList<String>();

		if (file.isEmpty() && noticia.getImagem().isEmpty()) {
			obj.add("warning");
			obj.add("Você precisa selecionar uma imagem");
			return obj;
		} 

		if(!file.isEmpty()) {

			try {
				// Get the file and save it somewhere
				byte[] bytes = file.getBytes();

				setFilename(file);

				Path path = Paths.get(getFilesPath() + getFilename());
				Files.write(path, bytes);
				
				noticia.setImagem(getFilename());

			} catch (IOException e) {
				e.printStackTrace();
				obj.add("fail");
				obj.add("Falha ao realizar upload da imagem!");
			}			
		}
		
		obj.add("success");
		obj.add("Operação realizada com sucesso!");
		
		return obj;
	}

	@Override
	public boolean removeFile(Long id){
		Noticia noticia = buscaPorId(id);

		if(noticia.getImagem() == null) {
			return true;
		}

		File file = new File(getFilesPath() + noticia.getImagem());

		noticia.setImagem(null);
		editar(noticia);

		if(file.delete()){
			return true;
		}


		return false;
	}

	public String getFilesPath() {
		return filesPath + "/noticias/";
	}
	
	@Override
	public boolean validaFomulario(Noticia noticia) {
		if(noticia.getTitulo().isEmpty() ||
		   noticia.getCategoria() == null ||
		   noticia.getData().toString().isEmpty() ||
		   noticia.getConteudo().isEmpty()
		   ) {
			return false;
		}
		
		return true;
	}
}
