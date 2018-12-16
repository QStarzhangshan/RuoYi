package com.ruoyi.project.elevator.car_wing.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

public class Car_wing extends BaseEntity{
	private Long id;
	private Long service_id;
	private String user_number;
	private Long car_wing;
	private Long car_door;
	private Long show_wing;
	private Long floor_wing;
	private Long emergency_alarm;
	private Long sentinal_plant;
	private Long weigh;
	private Long tank_guide_rail;
	private Long button_plate;
	private Long top_emergency_device;
	private Long top_lubrication;
	private Long top_vibration;
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
	public Long getCar_wing() {
		return car_wing;
	}
	public void setCar_wing(Long car_wing) {
		this.car_wing = car_wing;
	}
	public Long getCar_door() {
		return car_door;
	}
	public void setCar_door(Long car_door) {
		this.car_door = car_door;
	}
	public Long getShow_wing() {
		return show_wing;
	}
	public void setShow_wing(Long show_wing) {
		this.show_wing = show_wing;
	}
	public Long getFloor_wing() {
		return floor_wing;
	}
	public void setFloor_wing(Long floor_wing) {
		this.floor_wing = floor_wing;
	}
	public Long getEmergency_alarm() {
		return emergency_alarm;
	}
	public void setEmergency_alarm(Long emergency_alarm) {
		this.emergency_alarm = emergency_alarm;
	}
	public Long getSentinal_plant() {
		return sentinal_plant;
	}
	public void setSentinal_plant(Long sentinal_plant) {
		this.sentinal_plant = sentinal_plant;
	}
	public Long getWeigh() {
		return weigh;
	}
	public void setWeigh(Long weigh) {
		this.weigh = weigh;
	}
	public Long getTank_guide_rail() {
		return tank_guide_rail;
	}
	public void setTank_guide_rail(Long tank_guide_rail) {
		this.tank_guide_rail = tank_guide_rail;
	}
	public Long getButton_plate() {
		return button_plate;
	}
	public void setButton_plate(Long button_plate) {
		this.button_plate = button_plate;
	}
	public Long getTop_emergency_device() {
		return top_emergency_device;
	}
	public void setTop_emergency_device(Long top_emergency_device) {
		this.top_emergency_device = top_emergency_device;
	}
	public Long getTop_lubrication() {
		return top_lubrication;
	}
	public void setTop_lubrication(Long top_lubrication) {
		this.top_lubrication = top_lubrication;
	}
	public Long getTop_vibration() {
		return top_vibration;
	}
	public void setTop_vibration(Long top_vibration) {
		this.top_vibration = top_vibration;
	}
	@Override
	public String toString() {
		return "Car_wing [id=" + id + ", service_id=" + service_id + ", user_number=" + user_number + ", car_wing="
				+ car_wing + ", car_door=" + car_door + ", show_wing=" + show_wing + ", floor_wing=" + floor_wing
				+ ", emergency_alarm=" + emergency_alarm + ", sentinal_plant=" + sentinal_plant + ", weigh=" + weigh
				+ ", tank_guide_rail=" + tank_guide_rail + ", button_plate=" + button_plate + ", top_emergency_device="
				+ top_emergency_device + ", top_lubrication=" + top_lubrication + ", top_vibration=" + top_vibration
				+ "]";
	}
	
	
	
}
