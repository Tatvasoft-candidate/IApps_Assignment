package com.main.iapps.service;

import java.io.IOException;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.main.iapps.payload.NewsPaperResponse;

public interface NewsPaperService {

	public NewsPaperResponse getAllNewsPapers(Pageable pageable);

	public void save(MultipartFile file) throws IOException;
	
	public NewsPaperResponse getNewsPaperByName(String name, Pageable pageable);
}
