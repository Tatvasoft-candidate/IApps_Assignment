package com.main.iapps.entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "deviceInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeviceInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	public ScreenInfo screenInfo;

	private AppInfo appInfo;

	public DeviceInfo() {
	}

	public DeviceInfo(ScreenInfo screenInfo, AppInfo appinfo) {
		this.screenInfo = screenInfo;
		this.appInfo = appinfo;
	}

	public ScreenInfo getScreenInfo() {
		return screenInfo;
	}

	public void setScreenInfo(ScreenInfo screenInfo) {
		this.screenInfo = screenInfo;
	}

	public AppInfo getAppinfo() {
		return appInfo;
	}

	public void setAppinfo(AppInfo appinfo) {
		this.appInfo = appinfo;
	}

	@Override
	public String toString() {
		return "DeviceInfo [screenInfo=" + screenInfo + ", appInfo=" + appInfo + "]";
	}

	
}
