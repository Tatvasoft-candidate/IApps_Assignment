package com.main.iapps.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.main.iapps.exception.NewsPaperNotFoundException;
import com.main.iapps.payload.NewsPaperResponse;
import com.main.iapps.service.NewsPaperServiceImpl;

/**
 * This controller is to handle rest end-points of fetching the data and uploading the file.
 *
 * @author Tatvasoft
 * @since 14-February-2023
 */

@RestController
public class NewsPaperController {

	private static Logger log = LoggerFactory.getLogger(NewsPaperController.class);

	private final NewsPaperServiceImpl fileUploadServiceImpl;

	public NewsPaperController(NewsPaperServiceImpl fileUploadServiceImpl) {
		this.fileUploadServiceImpl = fileUploadServiceImpl;
	}

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

		log.info("File Upload Controller called");
		try {

			fileUploadServiceImpl.save(file);

			return ResponseEntity.ok("File uploaded successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to upload file: " + e.getMessage());
		}
	}

	@GetMapping("/newspapers")
	public ResponseEntity<NewsPaperResponse> getAllNewsPapers(Pageable pageable) {

		log.info("Get All NewsPapers Controller called");
		return new ResponseEntity<>(fileUploadServiceImpl.getAllNewsPapers(pageable), HttpStatus.OK);
	}

	@GetMapping("/newspapers/name")
	public ResponseEntity<NewsPaperResponse> getNewsPaperByName(@RequestParam String name, Pageable pageable) {

		log.info("Get NewsPaper By Name Controller called");
		
		NewsPaperResponse getNewsPaperByName = fileUploadServiceImpl.getNewsPaperByName(name, pageable);
		if(getNewsPaperByName==null || name.isEmpty())
			throw new NewsPaperNotFoundException("NewsPaper not Found");
		return ResponseEntity.ok(getNewsPaperByName);
	}

}
