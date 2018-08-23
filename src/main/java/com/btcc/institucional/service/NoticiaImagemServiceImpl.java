package com.btcc.institucional.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.btcc.institucional.dao.NoticiaImagemDao;
import com.btcc.institucional.domain.NoticiaImagem;

@Service @Transactional(readOnly = false)
public class NoticiaImagemServiceImpl extends AbstractService implements NoticiaImagemService{

	@Autowired
	private NoticiaImagemDao dao;
	
	@Value("${btcc.filesPathUpload}")
    private String filesPath;
	
	private String filename;
	
	@Override
	public void salvar(NoticiaImagem noticiaImagem) {
		dao.save(noticiaImagem);;
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override @Transactional(readOnly = true)
	public NoticiaImagem buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<NoticiaImagem> buscarTodos() {
		return dao.findAll();
	}
	
	@Override
	public ArrayList<String> uploadFile (MultipartFile file, NoticiaImagem noticiaImagem) {

		ArrayList<String> obj = new ArrayList<String>();

		if (file.isEmpty() && noticiaImagem.getTitulo().isEmpty()) {
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
				
				noticiaImagem.setTitulo(getFilename());

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
		NoticiaImagem noticiaImagem = buscaPorId(id);

		File file = new File(getFilesPath() + noticiaImagem.getTitulo());

		if(file.delete()){
			return true;
		}

		return false;
	}

	public String getFilesPath() {
		return filesPath + "/noticias/internas/";
	}

}
