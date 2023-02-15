package com.main.iapps.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NewsPaper {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "news_paper_name")
	private String newsPaperName;

	@Column(name = "width")
	private String width;

	@Column(name = "height")
	private String height;

	@Column(name = "dpi")
	private String dpi;

	@Column(name = "file_name")
	private String fileName;

	@Column(name = "upload_time")
	private LocalDateTime uploadTime;

	public NewsPaper() {
	}

	public NewsPaper(String newsPaperName, String width, String height, String dpi) {
		this.newsPaperName = newsPaperName;
		this.width = width;
		this.height = height;
		this.dpi = dpi;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNewsPaperName() {
		return newsPaperName;
	}

	public void setNewsPaperName(String newsPaperName) {
		this.newsPaperName = newsPaperName;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getDpi() {
		return dpi;
	}

	public void setDpi(String dpi) {
		this.dpi = dpi;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public LocalDateTime getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(LocalDateTime uploadTime) {
		this.uploadTime = uploadTime;
	}

	@Override
	public String toString() {
		return "NewsPaper [id=" + id + ", newsPaperName=" + newsPaperName + ", width=" + width + ", height=" + height
				+ ", dpi=" + dpi + ", fileName=" + fileName + ", uploadTime=" + uploadTime + "]";
	}

}
