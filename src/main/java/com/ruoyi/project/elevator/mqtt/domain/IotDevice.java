package com.ruoyi.project.elevator.mqtt.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

public class IotDevice extends BaseEntity{
	
	private long Id;
	private String productName;
	private String DeviceName;

	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDeviceName() {
		return DeviceName;
	}
	public void setDeviceName(String deviceName) {
		DeviceName = deviceName;
	}
	@Override
	public String toString() {
		return "IotDevice [Id=" + Id + ", productName=" + productName + ", DeviceName=" + DeviceName + "]";
	}
	
	
}
