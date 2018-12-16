package com.ruoyi.project.elevator.status.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 电梯状态修改 包括电梯基本信息和维保信息
 * @author zs
 *
 */
public class ElevatorStatusModify extends BaseEntity{

	private long id; //选择电梯id
	private String client_name;  //电梯业主
	private String payment_method; //支付方式
	private String contract_time; //合同日期
	private String contact_name; //联系人
	private String contact_phone; //联系人电话
	private String maintenance_company; //维保公司
	private String user_name; //维保人姓名
	private String phonenumber; //维保人姓名电话
	private String service_type; //维保类型
	private String maintenance_cost; //维保金额
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
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
	public String getMaintenance_company() {
		return maintenance_company;
	}
	public void setMaintenance_company(String maintenance_company) {
		this.maintenance_company = maintenance_company;
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
	public String getService_type() {
		return service_type;
	}
	public void setService_type(String service_type) {
		this.service_type = service_type;
	}
	public String getMaintenance_cost() {
		return maintenance_cost;
	}
	public void setMaintenance_cost(String maintenance_cost) {
		this.maintenance_cost = maintenance_cost;
	}
	@Override
	public String toString() {
		return "ElevatorStatusModify [id=" + id + ", client_name=" + client_name + ", payment_method=" + payment_method
				+ ", contract_time=" + contract_time + ", contact_name=" + contact_name + ", contact_phone="
				+ contact_phone + ", maintenance_company=" + maintenance_company + ", user_name=" + user_name
				+ ", phonenumber=" + phonenumber + ", service_type=" + service_type + ", maintenance_cost="
				+ maintenance_cost + "]";
	}
	
	
	
}
