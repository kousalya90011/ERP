package com.jfsd.erp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin_table")
public class Admin 
{
	@Id
	@Column(name = "adminid",length = 20)
	private int userid;   //while checking in postman we have to give userid:2898, pwd:"admin"
	
	@Column(name = "pwd",length = 50,nullable = false)
	private String pwd;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	


}
