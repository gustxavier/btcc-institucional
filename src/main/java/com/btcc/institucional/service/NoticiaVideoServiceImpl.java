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

import com.btcc.institucional.dao.NoticiaVideoDao;
import com.btcc.institucional.domain.NoticiaVideo;

@Service @Transactional(readOnly = false)
public class NoticiaVideoServiceImpl implements NoticiaVideoService {
	
	@Autowired
	private NoticiaVideoDao dao;
	
	@Value("${btcc.filesPathUpload}")
    private String filesPath;
	
	private String filename;
	
	@Override
	public void salvar(NoticiaVideo noticiaVideo) {
		dao.save(noticiaVideo);;
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override @Transactional(readOnly = true)
	public NoticiaVideo buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<NoticiaVideo> buscarTodos() {
		return dao.findAll();
	}
	
	@Override
	public ArrayList<String> uploadFile (MultipartFile file, NoticiaVideo noticiaVideo) {

		ArrayList<String> obj = new ArrayList<String>();

		if (file.isEmpty() && noticiaVideo.getTitulo().isEmpty()) {
			obj.add("warning");
			obj.add("Você precisa selecionar uma imagem");
			return obj;
		} 

		if(!file.isEmpty()) {

			try {
				// Get the file and save it somewhere
				byte[] bytes = file.getBytes();

				setFilename(file, noticiaVideo);

				Path path = Paths.get(getFilesPath() + getFilename());
				Files.write(path, bytes);
				
				noticiaVideo.setTitulo(getFilename());

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
		NoticiaVideo noticiaVideo = buscaPorId(id);

		File file = new File(getFilesPath() + noticiaVideo.getTitulo());

		if(file.delete()){
			return true;
		}

		return false;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(MultipartFile file, NoticiaVideo noticiaVideo) {
		String name = file.getOriginalFilename(); 
		String ext = name.substring(name.lastIndexOf("."),name.length()); 
		noticiaVideo.setExtensao(ext.substring(1));
		this.filename = System.currentTimeMillis() + ext;
	}

	public String getFilesPath() {
		return filesPath + "/noticias/videos/";
	}
}
