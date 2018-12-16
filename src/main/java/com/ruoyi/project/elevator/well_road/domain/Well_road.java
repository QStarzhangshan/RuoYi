package com.ruoyi.project.elevator.well_road.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

public class Well_road extends BaseEntity{

	
	private Long id;
	private Long service_id;
	private String user_number;
	private Long houta_hall;
	private Long gate_check;
	private Long gate_operation;
	private Long gate_interlocking;
	private Long well_cable;
	private Long limit_speed_switch;
	private Long door_plank;
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
	public Long getHouta_hall() {
		return houta_hall;
	}
	public void setHouta_hall(Long houta_hall) {
		this.houta_hall = houta_hall;
	}
	public Long getGate_check() {
		return gate_check;
	}
	public void setGate_check(Long gate_check) {
		this.gate_check = gate_check;
	}
	public Long getGate_operation() {
		return gate_operation;
	}
	public void setGate_operation(Long gate_operation) {
		this.gate_operation = gate_operation;
	}
	public Long getGate_interlocking() {
		return gate_interlocking;
	}
	public void setGate_interlocking(Long gate_interlocking) {
		this.gate_interlocking = gate_interlocking;
	}
	public Long getWell_cable() {
		return well_cable;
	}
	public void setWell_cable(Long well_cable) {
		this.well_cable = well_cable;
	}
	public Long getLimit_speed_switch() {
		return limit_speed_switch;
	}
	public void setLimit_speed_switch(Long limit_speed_switch) {
		this.limit_speed_switch = limit_speed_switch;
	}
	public Long getDoor_plank() {
		return door_plank;
	}
	public void setDoor_plank(Long door_plank) {
		this.door_plank = door_plank;
	}
	@Override
	public String toString() {
		return "Well_road [id=" + id + ", service_id=" + service_id + ", user_number=" + user_number + ", houta_hall="
				+ houta_hall + ", gate_check=" + gate_check + ", gate_operation=" + gate_operation
				+ ", gate_interlocking=" + gate_interlocking + ", well_cable=" + well_cable + ", limit_speed_switch="
				+ limit_speed_switch + ", door_plank=" + door_plank + "]";
	}
	
	
	
	
}
