package com.ruoyi.project.elevator.status.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

public class Maintenance extends BaseEntity{

	private long id;
	private long elevator_id;
	private long dept_id;
	private long user_id;
	private String dept_name;
	private String maintenance_name;
	private String maintenance_phone;
	private String maintenance_email;
	private String maintenance_loginname;
	private String maintenance_firsttime;
	private String maintenance_nexttime;
	private String maintenance_cost;
	private long maintenance_cycle;
	private long maintenance_grap;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getElevator_id() {
		return elevator_id;
	}
	public void setElevator_id(long elevator_id) {
		this.elevator_id = elevator_id;
	}
	public long getDept_id() {
		return dept_id;
	}
	public void setDept_id(long dept_id) {
		this.dept_id = dept_id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getMaintenance_name() {
		return maintenance_name;
	}
	public void setMaintenance_name(String maintenance_name) {
		this.maintenance_name = maintenance_name;
	}
	public String getMaintenance_phone() {
		return maintenance_phone;
	}
	public void setMaintenance_phone(String maintenance_phone) {
		this.maintenance_phone = maintenance_phone;
	}
	public String getMaintenance_email() {
		return maintenance_email;
	}
	public void setMaintenance_email(String maintenance_email) {
		this.maintenance_email = maintenance_email;
	}
	public String getMaintenance_loginname() {
		return maintenance_loginname;
	}
	public void setMaintenance_loginname(String maintenance_loginname) {
		this.maintenance_loginname = maintenance_loginname;
	}
	public String getMaintenance_firsttime() {
		return maintenance_firsttime;
	}
	public void setMaintenance_firsttime(String maintenance_firsttime) {
		this.maintenance_firsttime = maintenance_firsttime;
	}
	public String getMaintenance_nexttime() {
		return maintenance_nexttime;
	}
	public void setMaintenance_nexttime(String maintenance_nexttime) {
		this.maintenance_nexttime = maintenance_nexttime;
	}
	public String getMaintenance_cost() {
		return maintenance_cost;
	}
	public void setMaintenance_cost(String maintenance_cost) {
		this.maintenance_cost = maintenance_cost;
	}
	public long getMaintenance_cycle() {
		return maintenance_cycle;
	}
	public void setMaintenance_cycle(long maintenance_cycle) {
		this.maintenance_cycle = maintenance_cycle;
	}
	public long getMaintenance_grap() {
		return maintenance_grap;
	}
	public void setMaintenance_grap(long maintenance_grap) {
		this.maintenance_grap = maintenance_grap;
	}
	@Override
	public String toString() {
		return "Maintenance [id=" + id + ", elevator_id=" + elevator_id + ", dept_id=" + dept_id + ", user_id="
				+ user_id + ", dept_name=" + dept_name + ", maintenance_name=" + maintenance_name
				+ ", maintenance_phone=" + maintenance_phone + ", maintenance_email=" + maintenance_email
				+ ", maintenance_loginname=" + maintenance_loginname + ", maintenance_firsttime="
				+ maintenance_firsttime + ", maintenance_nexttime=" + maintenance_nexttime + ", maintenance_cost="
				+ maintenance_cost + ", maintenance_cycle=" + maintenance_cycle + ", maintenance_grap="
				+ maintenance_grap + "]";
	}
	
}
