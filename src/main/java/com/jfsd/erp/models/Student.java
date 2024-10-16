package com.jfsd.erp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_table")
@PrimaryKeyJoinColumn(name = "student_id") 
public class Student extends User
{
	
	 @Column(name = "batch_id",nullable = false)
	 private int batchId;
	 
	 @Column(name = "cgpa",nullable = false)
	 private double cgpa;
	 
	 @Column(name = "fee_status",length= 50,nullable = false)
	 private boolean feestatus;
	 
	 @Column(name = "parentname",length = 50,nullable = false)
	 private String parentname;
	 //private String prevEducation;
	 
	 @Column(name = "department", nullable = false, length = 100)
	 private String department;


	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId =batchId;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public boolean isFeestatus() {
		return feestatus;
	}

	public void setFeestatus(boolean feestatus) {
		this.feestatus = feestatus;
	}

	public String getParentname() {
		return parentname;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
