package com.main.iapps.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "screenInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class ScreenInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlAttribute(name = "width")
	private String width;

	@XmlAttribute(name = "height")
	private String height;

	@XmlAttribute(name = "dpi")
	private String dpi;

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

	@Override
	public String toString() {
		return "ScreenInfo [width=" + width + ", height=" + height + ", dpi=" + dpi + "]";
	}
}
