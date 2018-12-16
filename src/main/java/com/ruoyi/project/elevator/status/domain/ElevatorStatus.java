package com.ruoyi.project.elevator.status.domain;

import java.util.Date;

import com.ruoyi.framework.web.domain.BaseEntity;

public class ElevatorStatus extends BaseEntity{

    private long id;
    private  String user_number;//工号
    private  String client_name;
    private  String ladder_number;
    private  String model;
    private  String portal_door;
    private  String serial_number;
    private  String registration_code;
    private  String first_certificate;
    private  String payment_method;
    private  String contract_time;
    private  String contact_name;
    private  String contact_phone;
    private  String address;
    private String province;//省
    private String city;//市
    private String area;//地区或镇
    private String building;//楼
    private String elevator_number;//电梯号
    private  String service_type;
    private String run_time;
    private String contract_btime; //合同开始时间
    private String contract_etime; //合同结束时间
     
    



	public String getContract_btime() {
		return contract_btime;
	}

	public void setContract_btime(String contract_btime) {
		this.contract_btime = contract_btime;
	}

	public String getContract_etime() {
		return contract_etime;
	}

	public void setContract_etime(String contract_etime) {
		this.contract_etime = contract_etime;
	}

	public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getLadder_number() {
        return ladder_number;
    }

    public void setLadder_number(String ladder_number) {
        this.ladder_number = ladder_number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPortal_door() {
        return portal_door;
    }

    public void setPortal_door(String portal_door) {
        this.portal_door = portal_door;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getRegistration_code() {
        return registration_code;
    }

    public void setRegistration_code(String registration_code) {
        this.registration_code = registration_code;
    }

    public String getFirst_certificate() {
        return first_certificate;
    }

    public void setFirst_certificate(String first_certificate) {
        this.first_certificate = first_certificate;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getContract_time() {
        return contract_time;
    }

    public void setContract_time(String contract_time) {
        this.contract_time = contract_time;
    }



    public String getContact_name() {
		return contact_name;
	}

	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}

	public String getContact_phone() {
		return contact_phone;
	}

	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}

	public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser_number() {
        return user_number;
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

    public String getRun_time() {
        return run_time;
    }

    public void setRun_time(String run_time) {
        this.run_time = run_time;
    }

	@Override
	public String toString() {
		return "ElevatorStatus [id=" + id + ", user_number=" + user_number + ", client_name=" + client_name
				+ ", ladder_number=" + ladder_number + ", model=" + model + ", portal_door=" + portal_door
				+ ", serial_number=" + serial_number + ", registration_code=" + registration_code
				+ ", first_certificate=" + first_certificate + ", payment_method=" + payment_method + ", contract_time="
				+ contract_time + ", contact_name=" + contact_name + ", contact_phone=" + contact_phone + ", address="
				+ address + ", province=" + province + ", city=" + city + ", area=" + area + ", building=" + building
				+ ", elevator_number=" + elevator_number + ", service_type=" + service_type + ", run_time=" + run_time
				+ ", contract_btime=" + contract_btime + ", contract_etime=" + contract_etime + "]";
	}





  
}
