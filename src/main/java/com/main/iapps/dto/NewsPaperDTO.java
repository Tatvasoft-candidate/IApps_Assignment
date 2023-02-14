package com.main.iapps.dto;

public class NewsPaperDTO {

	public String id;
	private String newsPaperName;
	private String width;
	private String height;
	private String dpi;

	public NewsPaperDTO() {

	}

	public NewsPaperDTO(String id, String newsPaperName, String width, String height, String dpi) {
		this.id = id;
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

}
