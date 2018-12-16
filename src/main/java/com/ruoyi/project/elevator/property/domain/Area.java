package com.ruoyi.project.elevator.property.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

public class Area extends BaseEntity{
	
	private long id;
	private long dept_id;
	private String dept_name;
	private String area_name;
	private String province;
	private String city;
	private String area;
	private String address;
	private String create_time;
	private long elevator_number;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getDept_id() {
		return dept_id;
	}
	public void setDept_id(long dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public long getElevator_number() {
		return elevator_number;
	}
	public void setElevator_number(long elevator_number) {
		this.elevator_number = elevator_number;
	}
	@Override
	public String toString() {
		return "Area [id=" + id + ", dept_id=" + dept_id + ", dept_name=" + dept_name + ", area_name=" + area_name
				+ ", province=" + province + ", city=" + city + ", area=" + area + ", address=" + address
				+ ", create_time=" + create_time + ", elevator_number=" + elevator_number + "]";
	}
	
}
