package com.btcc.institucional.service;

import com.btcc.institucional.dao.ImagemDao;
import com.btcc.institucional.domain.Imagem;
import com.btcc.institucional.domain.ImagemLocal;
import com.btcc.institucional.domain.ImagemTipo;
import com.btcc.institucional.service.ImagemService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service @Transactional(readOnly = false)
public class ImagemServiceImpl implements ImagemService{
	
	@Value("${btcc.filesPathUpload}")
    private String filesPath;

	private String filename;
	
	ArrayList<String> obj = new ArrayList<String>();
	
	@Autowired
	private ImagemDao dao;

	@Override
	public void salvar(Imagem imagem) {
		dao.save(imagem);
	}

	@Override
	public void editar(Imagem imagem) {
		dao.update(imagem);
	}

	@Override
	public void excluir (Long id) {
		dao.delete(id);		
	}

	@Override @Transactional(readOnly = true)
	public Imagem buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Imagem> buscarTodos(ImagemTipo local) {
		return dao.findAll(local);
	}
	
	@Override
	public ArrayList<String> uploadFile (MultipartFile file, Imagem imagem) {		

		if (file.isEmpty() && imagem.getTitulo().isEmpty()) {
			obj.add("warning");
			obj.add("Você precisa selecionar uma imagem");
			return obj;
		}

		try {
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			
			setFileNameIfNotExists(imagem);
			
//			Path path = Paths.get(directory_uri_upload + "//" + getFilename());
			System.out.println(getFilename());
			imagem.setTitulo(getFilename());

		} catch (IOException e) {
			e.printStackTrace();
		}

		obj.add("success");
		obj.add("Operação realizada com sucesso!");

		return obj;
	}
	
	@Override
	public boolean removeFile(Long id){

		Imagem imagem = buscaPorId(id);

		if(imagem.getTitulo() == null) {
			return true;
		}
		
		File file = new File(getFilesPath() + imagem.getTitulo());

		if(file.delete()){
			return true;
		}
		return false;
	}

	public void setFileNameIfNotExists(Imagem imagem) {
		
		String prefix;
		
		if((String)imagem.getLocal() == (String)ImagemLocal.topo.getLocal()) {
			System.out.println("oi");
			prefix = "pessoa-bem-vindo-";
		} else if(imagem.getLocal() == ImagemLocal.meio.getLocal()){
			System.out.println("népossivel");
			prefix = "pessoa-trabalhe-conosco-";
		} else {
			System.out.println("putz");
			prefix = "pessoa-onde-estamos-";
		}

		for (int i = 1; i <= 3; i++) {
			if(!isTituloExists(prefix + i + ".png")) {
				System.out.println(prefix + i + ".png");
				setFilename(prefix + i + ".png");
				break;
			}
		}
	}
	
	public boolean isTituloExists(String titulo) {
		if(!dao.findByImagetitle(titulo).isEmpty()) {
			return true;
		}			
		return false;
	}
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public ArrayList<String> validaCamposAdicionar(MultipartFile file, Imagem imagem) {
		
		this.obj.clear();
		
		if(file.isEmpty()) {
			this.obj.add("warning");
			this.obj.add("Você precisa selecionar uma imagem");
			this.obj.add("redirect:/admin/imagens/cadastrar-home");
		}
		
		if(imagem.getLocal().isEmpty()) {
			this.obj.add("warning");
			this.obj.add("Você precisa selecionar o local onde a imagem deve aparecer");
			this.obj.add("redirect:/admin/imagens/cadastrar-home");
		}

		return this.obj;
	}

	public String getFilesPath() {
		return filesPath + "/imagens/";
	}
	
}
