package com.jfsd.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.erp.models.Faculty;
import com.jfsd.erp.repository.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService 
{
	@Autowired
	private FacultyRepository facultyRepository;

	@Override
	public String FacultyRegistration(Faculty f) {
		facultyRepository.save(f);
		return "Faculty Registered Successfully";
	}

	@Override
	public Faculty checklogin(String email, String password) {
		return facultyRepository.checkFacultylogin(email, password);
	}

}
