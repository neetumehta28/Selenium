package com.acorp.adap.dto;

public class User {
	private String userid;
	private String password;
	private String status;
	
	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", password=" + password + ", status=" + status + "]";
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public String setStatus(String status) {
		this.status = status;
		return status;
	}
	
}