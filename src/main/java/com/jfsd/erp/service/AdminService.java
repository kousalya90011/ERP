package com.jfsd.erp.service;

import java.util.List;

import com.jfsd.erp.models.Admin;
import com.jfsd.erp.models.Faculty;
import com.jfsd.erp.models.Student;

public interface AdminService 
{
	public Admin checklogin(int userid, String pwd);
	public List<Faculty> viewallfaculty();
	public List<Student> viewallstudents();
}
