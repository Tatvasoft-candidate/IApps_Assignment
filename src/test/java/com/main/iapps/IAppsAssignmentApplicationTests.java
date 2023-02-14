package com.main.iapps;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.main.iapps.dao.NewsPaperRepository;
import com.main.iapps.entity.AppInfo;
import com.main.iapps.entity.DeviceInfo;
import com.main.iapps.entity.EPaperRequest;
import com.main.iapps.entity.NewsPaper;
import com.main.iapps.entity.ScreenInfo;
import com.main.iapps.service.NewsPaperServiceImpl;

@SpringBootTest
class IAppsAssignmentApplicationTests {


	@Autowired
	private NewsPaperServiceImpl service;

	@MockBean
	NewsPaperRepository repository;

	@Test
	public void getNewsPaper(){
		Pageable pageable=PageRequest.of(0,2);
		List<NewsPaper> responseList=dataForMock();
		Page<NewsPaper> pageData=new PageImpl<>(responseList);
		Mockito.when(repository.findAll(pageable)).thenReturn(pageData);

	}

	public List<NewsPaper> dataForMock(){
		NewsPaper data=new NewsPaper();
		List<NewsPaper> dataList=new ArrayList<>();
		for(int i=0;i<2;i++){
			data.setDpi("160");
			data.setHeight("750");
			data.setNewsPaperName("abb");
			data.setWidth("1280");
			data.setFileName("parse.xml");
			dataList.add(data);
		}
		return dataList;
	}

	public NewsPaper response(){
		NewsPaper data=new NewsPaper();
		data.setDpi("160");
		data.setHeight("750");
		data.setNewsPaperName("abb");
		data.setWidth("1280");
		data.setFileName("parse.xml");
		return data;
	}
	
	EPaperRequest request(){
		EPaperRequest req=new EPaperRequest();
		req.setDeviceInfo(deviceInfo());
		return req;
	}

	ScreenInfo screenInfo(){
		ScreenInfo screenInfo=new ScreenInfo();
		screenInfo.setDpi("160");
		screenInfo.setHeight("750");
		screenInfo.setWidth("1280");
		return screenInfo;
	}

	DeviceInfo deviceInfo(){
		DeviceInfo deviceInfo=new DeviceInfo();
		deviceInfo.setScreenInfo(screenInfo());
		deviceInfo.setAppinfo(appInfo());
		return deviceInfo;
	}

	AppInfo appInfo(){
		AppInfo info=new AppInfo();
		info.setNewsPaperName("abb");
		info.setVersion("1.0");
		return info;
	}


	@Test
	public void getNewsPaperByPaging(){
		Pageable pageable=PageRequest.of(0,2);
		List<NewsPaper> list=dataForMock();
		Page<NewsPaper> page=new PageImpl<>(list);

		Mockito.when(repository.findAll(pageable)).thenReturn(page);
	}

	@Test
	public void getNewsPaperByName(){
		Pageable pageable=PageRequest.of(0,2);
		List<NewsPaper> responseList=dataForMock();
		Page<NewsPaper> pageData=new PageImpl<>(responseList);
		Mockito.when(repository.findByNewsPaperNameContains("abb",pageable)).thenReturn(pageData);
	}

	@Test
	public void getNewsPaperByNameAndPaging(){
		Pageable pageable=PageRequest.of(0,2);
		List<NewsPaper> list=dataForMock();
		Page<NewsPaper> page=new PageImpl<>(list);

		Mockito.when(repository.findAll(pageable)).thenReturn(page);
	}
	 

}
