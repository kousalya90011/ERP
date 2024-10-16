package com.jfsd.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.erp.models.Student;
import com.jfsd.erp.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public String StudentRegistration(Student s) {
		studentRepository.save(s);
		return "Student Registered Successfully";
	}

	@Override
	public Student checkstudentlogin(String email, String password) {
		return studentRepository.checkStudentlogin(email, password);
	}

}
