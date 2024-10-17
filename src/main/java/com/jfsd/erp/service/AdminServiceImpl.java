package com.jfsd.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.erp.models.Admin;
import com.jfsd.erp.models.Faculty;
import com.jfsd.erp.models.Student;
import com.jfsd.erp.repository.AdminRepository;
import com.jfsd.erp.repository.FacultyRepository;
import com.jfsd.erp.repository.StudentRepository;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private FacultyRepository facultyRepository;
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Admin checklogin(int userid, String pwd) {
		return  adminRepository.checklogin(userid, pwd);
	}

	@Override
	public List<Faculty> viewallfaculty() {
		return  facultyRepository.findAll();
	}

	@Override
	public List<Student> viewallstudents() {
		return studentRepository.findAll();
	}

	@Override
	public String deletefacultybyEmail(String femail) {
		facultyRepository.deletefacultybyEmail(femail);
		return "Faculty Moved to Old Staff Records Successfully";
	}
}
