package com.ruoyi.project.elevator.service.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

public class Service extends BaseEntity{

    private long id;
    private long service_id;
    private String user_number;
    private String user_name;
    private String phonenumber;
    private String province;
    private String city;
    private String area;
    private String building;
    private String elevator_number;
    private String maintenance_company;
    private String maintenance_cost;
    private String service_type;
    private String task_createtime;
    private String task_endtime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getService_id() {
        return service_id;
    }

    public void setService_id(long service_id) {
        this.service_id = service_id;
    }

    public String getUser_number() {
        return user_number;
    }

    
    public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getMaintenance_company() {
		return maintenance_company;
	}

	public void setMaintenance_company(String maintenance_company) {
		this.maintenance_company = maintenance_company;
	}

	public String getMaintenance_cost() {
		return maintenance_cost;
	}

	public void setMaintenance_cost(String maintenance_cost) {
		this.maintenance_cost = maintenance_cost;
	}

	public void setUser_number(String user_number) {
        this.user_number = user_number;
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

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getElevator_number() {
        return elevator_number;
    }

    public void setElevator_number(String elevator_number) {
        this.elevator_number = elevator_number;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getTask_createtime() {
        return task_createtime;
    }

    public void setTask_createtime(String task_createtime) {
        this.task_createtime = task_createtime;
    }

    public String getTask_endtime() {
        return task_endtime;
    }

    public void setTask_endtime(String task_endtime) {
        this.task_endtime = task_endtime;
    }

	@Override
	public String toString() {
		return "Service [id=" + id + ", service_id=" + service_id + ", user_number=" + user_number + ", user_name="
				+ user_name + ", phonenumber=" + phonenumber + ", province=" + province + ", city=" + city + ", area="
				+ area + ", building=" + building + ", elevator_number=" + elevator_number + ", maintenance_company="
				+ maintenance_company + ", maintenance_cost=" + maintenance_cost + ", service_type=" + service_type
				+ ", task_createtime=" + task_createtime + ", task_endtime=" + task_endtime + "]";
	}

    

}
