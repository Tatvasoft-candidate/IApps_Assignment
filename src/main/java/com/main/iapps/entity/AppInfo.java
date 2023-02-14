package com.main.iapps.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "appInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class AppInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String newspaperName;

	private String version;

	public AppInfo() {
	}

	public AppInfo(String newsPaperName, String version) {
		this.newspaperName = newsPaperName;
		this.version = version;
	}

	public String getNewsPaperName() {
		return newspaperName;
	}

	public void setNewsPaperName(String newsPaperName) {
		this.newspaperName = newsPaperName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String string) {
		this.version = string;
	}

	@Override
	public String toString() {
		return "AppInfo [newsPaperName=" + newspaperName + ", version=" + version + "]";
	}

	
}
