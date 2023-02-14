package com.main.iapps.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import com.main.iapps.dao.NewsPaperRepository;
import com.main.iapps.dto.NewsPaperDTO;
import com.main.iapps.entity.EPaperRequest;
import com.main.iapps.entity.NewsPaper;
import com.main.iapps.payload.NewsPaperResponse;

/**
 * This class is to handle all the methods that rest end-points are using of fetching the data and uploading the file.
 *
 * @author Tatvasoft
 * @since 14-February-2023
 */

@Service
public class NewsPaperServiceImpl implements NewsPaperService {

	private static Logger log = LoggerFactory.getLogger(NewsPaperServiceImpl.class);

	private final NewsPaperRepository newsPaperRepository;

	public NewsPaperServiceImpl(NewsPaperRepository fileUploadRepository) {
		this.newsPaperRepository = fileUploadRepository;
	}

	@Override
	public void save(MultipartFile file) throws IOException {
		
		log.info("File Uploading method called");

		Resource resource = new ClassPathResource("newspaper-details.xsd", NewsPaperServiceImpl.class.getClassLoader());

		InputStream input = resource.getInputStream();

		File xsd = resource.getFile();
		String fileName = file.getOriginalFilename();

		if (validateXMLSchema(file.getInputStream(), new FileInputStream(xsd))) {

			List<NewsPaper> newsPaper = parseXMLFile(file, fileName);

			if (newsPaper != null)
				newsPaperRepository.saveAll(newsPaper);
			else
				throw new RuntimeException();
		} else {
			log.info("Error in validating xml");
		}

	}

	@Override
	public NewsPaperResponse getAllNewsPapers(Pageable pageable) {
		
		log.info("List of All NewsPapers method called");

		Page<NewsPaper> getNewsPapers = newsPaperRepository.findAll(pageable);

		List<NewsPaper> listOfNewsPaper = getNewsPapers.getContent();

		List<NewsPaperDTO> getNewsPaperDto = listOfNewsPaper.stream().map(newsPaper -> mapToDTO(newsPaper))
				.collect(Collectors.toList());

		NewsPaperResponse newsPaperResponse = convertToResponse(getNewsPapers, getNewsPaperDto);

		return newsPaperResponse;
	}

	public NewsPaperResponse getNewsPaperByName(String name, Pageable pageable) {
		
		log.info("Find NewsPaperByName method called");

		Page<NewsPaper> getNewsPaperByName = newsPaperRepository.findByNewsPaperNameContains(name, pageable);

		List<NewsPaperDTO> getNewsPaper = getNewsPaperByName.stream().map(newsPaper -> mapToDTO(newsPaper))
				.collect(Collectors.toList());

		NewsPaperResponse newsPaperResponse = convertToResponse(getNewsPaperByName, getNewsPaper);

		return newsPaperResponse;
	}
	
	
	/*
	 * This method is defined to validate XML Schema against XSD.
	 */
	public boolean validateXMLSchema(InputStream xml, InputStream xsd) {

		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new StreamSource(xsd));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(xml));
		} catch (IOException | SAXException e) {

			e.printStackTrace();
			return false;
		}
		return true;
	}

	/*
	 * Method is defined to parse XML Content to Java POJO using JAXB.
	 */
	public List<NewsPaper> parseXMLFile(MultipartFile file, String fileName) {
		List<NewsPaper> newsPaperList = new ArrayList<>();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(EPaperRequest.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			String fileContent = new String(file.getBytes());
			EPaperRequest paperRequest = (EPaperRequest) jaxbUnmarshaller.unmarshal(new StringReader(fileContent));

			NewsPaper newsPaper = new NewsPaper();
			newsPaper.setId(UUID.randomUUID().toString());
			newsPaper.setNewsPaperName(paperRequest.getDeviceInfo().getAppinfo().getNewsPaperName());
			newsPaper.setDpi(paperRequest.getDeviceInfo().getScreenInfo().getDpi());
			newsPaper.setWidth(paperRequest.getDeviceInfo().getScreenInfo().getWidth());
			newsPaper.setHeight(paperRequest.getDeviceInfo().getScreenInfo().getHeight());
			newsPaper.setFileName(fileName);
			newsPaper.setUploadTime(LocalDateTime.now());
			newsPaperList.add(newsPaper);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return newsPaperList;
	}

	/*
	 * This method has defined to handle paginated properties on response.
	 */
	private NewsPaperResponse convertToResponse(Page<NewsPaper> getNewsPapers, List<NewsPaperDTO> getNewsPaperDto) {
		NewsPaperResponse newsPaperResponse = new NewsPaperResponse();
		newsPaperResponse.setNewsPapers(getNewsPaperDto);
		newsPaperResponse.setPageNo(getNewsPapers.getNumber());
		newsPaperResponse.setPageSize(getNewsPapers.getSize());
		newsPaperResponse.setTotalElements(getNewsPapers.getTotalElements());
		newsPaperResponse.setTotalPages(getNewsPapers.getTotalPages());
		newsPaperResponse.setLast(getNewsPapers.isLast());
		return newsPaperResponse;
	}
	
	
	/*
	 * This method has defined to map to DTO for better response.
	 */
	private NewsPaperDTO mapToDTO(NewsPaper newsPaper) {
		NewsPaperDTO newsPaperDto = new NewsPaperDTO();
		newsPaperDto.setId(newsPaper.getId());
		newsPaperDto.setNewsPaperName(newsPaper.getNewsPaperName());
		newsPaperDto.setWidth(newsPaper.getWidth());
		newsPaperDto.setHeight(newsPaper.getHeight());
		newsPaperDto.setDpi(newsPaper.getDpi());

		return newsPaperDto;
	}

}
