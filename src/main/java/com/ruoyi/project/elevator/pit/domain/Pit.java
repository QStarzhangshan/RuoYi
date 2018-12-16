package com.ruoyi.project.elevator.pit.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

public class Pit extends BaseEntity{
	
	
	private Long id;
	private Long service_id;
	private String user_number;
	private Long light;
	private Long sudden_stop_switch;
	private Long rovolve_member;
	private Long pond;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getService_id() {
		return service_id;
	}
	public void setService_id(Long service_id) {
		this.service_id = service_id;
	}
	public String getUser_number() {
		return user_number;
	}
	public void setUser_number(String user_number) {
		this.user_number = user_number;
	}
	public Long getLight() {
		return light;
	}
	public void setLight(Long light) {
		this.light = light;
	}
	public Long getSudden_stop_switch() {
		return sudden_stop_switch;
	}
	public void setSudden_stop_switch(Long sudden_stop_switch) {
		this.sudden_stop_switch = sudden_stop_switch;
	}
	public Long getRovolve_member() {
		return rovolve_member;
	}
	public void setRovolve_member(Long rovolve_member) {
		this.rovolve_member = rovolve_member;
	}
	public Long getPond() {
		return pond;
	}
	public void setPond(Long pond) {
		this.pond = pond;
	}
	@Override
	public String toString() {
		return "Pit [id=" + id + ", service_id=" + service_id + ", user_number=" + user_number + ", light=" + light
				+ ", sudden_stop_switch=" + sudden_stop_switch + ", rovolve_member=" + rovolve_member + ", pond=" + pond
				+ "]";
	}
	
	
}
