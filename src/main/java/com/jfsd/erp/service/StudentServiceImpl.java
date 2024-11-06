package com.jfsd.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.erp.models.Enrollment;
import com.jfsd.erp.models.Section;
import com.jfsd.erp.models.Student;
import com.jfsd.erp.repository.CourseFacultyRepository;
import com.jfsd.erp.repository.EnrollmentRepository;
import com.jfsd.erp.repository.SectionRepository;
import com.jfsd.erp.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private SectionRepository sectionRepository;
	@Autowired
	private EnrollmentRepository enrollmentRepository;

	@Override
	public String StudentRegistration(Student s) {
		studentRepository.save(s);
		return "Student Registered Successfully";
	}

	@Override
	public Student checkstudentlogin(String email, String password) {
		return studentRepository.checkStudentlogin(email, password);
	}
	@Override
	public List<Section> getAvailableSections() {
        // Here you may filter sections based on capacity
        return sectionRepository.findAll();
    }
	@Override

    // Register a student for a section
    public void register(Enrollment enrollment) {
        enrollmentRepository.save(enrollment);
    }

    // Get all enrolled sections for a student
	@Override
    public List<Enrollment> getStudentEnrollments(int studentId) {
        return enrollmentRepository.findByStudent_UserStuId(studentId);
    }

}
