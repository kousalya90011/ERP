package com.jfsd.erp.models;

import java.util.Random;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "faculty_table")
@PrimaryKeyJoinColumn(name = "user_fac_id")
public class Faculty extends User {
	
	@Column(name="user_fac_id",insertable=false,updatable = false)
    private int userfacId;
	
	@Column(name="faculty_id",nullable=false,length=20)
	private String facultyId;


    @Column(name = "designation", nullable = false, length = 100)
    private String designation;

    @Column(name = "faculty_salary", nullable = false)
    private double salary;

    @Column(name = "faculty_status", nullable = false)
    private String reg_status;
    

    @ManyToMany
    @JoinTable(
        name = "course_faculty",
        joinColumns = @JoinColumn(name = "user_fac_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;

    @ManyToMany
    @JoinTable(
        name = "section_faculty",
        joinColumns = @JoinColumn(name = "user_fac_id"),
        inverseJoinColumns = @JoinColumn(name = "section_id")
    )
    private Set<Section> sections;

    
    // Custom method to generate Faculty ID
    public String generateFacultyId() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }

    public Faculty() {
        // Custom faculty ID generation logic
        this.setFacultyId(generateFacultyId());  // Override the ID from User
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

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	public int getUserfacId() {
		return userfacId;
	}

	public void setUserfacId(int userfacId) {
		this.userfacId = userfacId;
	}

	public String getReg_status() {
		return reg_status;
	}

	public void setReg_status(String reg_status) {
		this.reg_status = reg_status;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Set<Section> getSections() {
		return sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

	
}
