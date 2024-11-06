package com.jfsd.erp.service;

import java.util.List;

import com.jfsd.erp.models.Enrollment;
import com.jfsd.erp.models.Section;
import com.jfsd.erp.models.Student;

public interface StudentService 
{
	public String StudentRegistration(Student f);
	public Student checkstudentlogin(String email,String password);
	public void register(Enrollment enrollment);
	public List<Enrollment> getStudentEnrollments(int studentId);
	public List<Section> getAvailableSections();
}
