package com.main.iapps.entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "epaperRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class EPaperRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private DeviceInfo deviceInfo;

	public EPaperRequest() {
	}

	public EPaperRequest(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	@Override
	public String toString() {
		return "EPaperRequest [deviceInfo=" + deviceInfo + "]";
	}

	
}
