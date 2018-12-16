package com.ruoyi.project.elevator.mqtt.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

public class RealTimeData extends BaseEntity{

	private long id;
	private long iotId;
	private String currentStatus;
	private String playWay;
	private String currentRank;
	private String doorStatus;
	private String playDirection;
	private String playSpeed;
	private String totalDate;
	private String totalTime;
	private String faultInfo;
	private String faultCode;
	private String uploadTime;
	
	
	public String getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIotId() {
		return iotId;
	}
	public void setIotId(long iotId) {
		this.iotId = iotId;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getPlayWay() {
		return playWay;
	}
	public void setPlayWay(String playWay) {
		this.playWay = playWay;
	}
	public String getCurrentRank() {
		return currentRank;
	}
	public void setCurrentRank(String currentRank) {
		this.currentRank = currentRank;
	}
	public String getDoorStatus() {
		return doorStatus;
	}
	public void setDoorStatus(String doorStatus) {
		this.doorStatus = doorStatus;
	}
	public String getPlayDirection() {
		return playDirection;
	}
	public void setPlayDirection(String playDirection) {
		this.playDirection = playDirection;
	}
	public String getPlaySpeed() {
		return playSpeed;
	}
	public void setPlaySpeed(String playSpeed) {
		this.playSpeed = playSpeed;
	}
	public String getTotalDate() {
		return totalDate;
	}
	public void setTotalDate(String totalDate) {
		this.totalDate = totalDate;
	}
	public String getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}
	public String getFaultInfo() {
		return faultInfo;
	}
	public void setFaultInfo(String faultInfo) {
		this.faultInfo = faultInfo;
	}
	public String getFaultCode() {
		return faultCode;
	}
	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}
	@Override
	public String toString() {
		return "RealTimeData [id=" + id + ", iotId=" + iotId + ", currentStatus=" + currentStatus + ", playWay="
				+ playWay + ", currentRank=" + currentRank + ", doorStatus=" + doorStatus + ", playDirection="
				+ playDirection + ", playSpeed=" + playSpeed + ", totalDate=" + totalDate + ", totalTime=" + totalTime
				+ ", faultInfo=" + faultInfo + ", faultCode=" + faultCode + ", uploadTime=" + uploadTime + "]";
	}

	
	

}
