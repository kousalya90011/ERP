package com.jfsd.erp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "faculty_table")
@PrimaryKeyJoinColumn(name = "faculty_id") 
public class Faculty extends User
{
      
	 @Column(name = "department", nullable = false, length = 100)
	 private String department;

	  @Column(name = "designation", nullable = false, length = 100)
	  private String designation;
	  
	  @Column(name = "faculty_salary",nullable = false)
	  private double salary;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	  
}
