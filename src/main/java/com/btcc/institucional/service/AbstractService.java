package com.btcc.institucional.service;

import javax.persistence.MappedSuperclass;

import org.springframework.web.multipart.MultipartFile;

import com.btcc.institucional.config.SecurityConfig;

@MappedSuperclass
public abstract class AbstractService {
	
	private String filename;
	
	public String getFilename() {
		return this.filename;
	}

	public void setFilename(MultipartFile file) {
		String name = file.getOriginalFilename(); 
		String ext = name.substring(name.lastIndexOf("."),name.length()); 
		
		String currentTime = Long.toString(System.currentTimeMillis());
		String session = SecurityConfig.session().getId().toLowerCase();
		StringBuilder newFileName = new StringBuilder();
		
		for (int i = 0; i < currentTime.length(); i++) {
			newFileName.append(currentTime.charAt(i));
			newFileName.append(session.charAt(i));
		}

		this.filename = newFileName.toString() + ext;
	}
	
}
