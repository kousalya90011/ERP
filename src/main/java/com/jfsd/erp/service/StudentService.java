package com.jfsd.erp.service;

import com.jfsd.erp.models.Student;

public interface StudentService 
{
	public String StudentRegistration(Student f);
	public Student checkstudentlogin(String email,String password);
}
