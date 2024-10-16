package com.jfsd.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jfsd.erp.models.Student;
import com.jfsd.erp.models.User.Role;
import com.jfsd.erp.service.StudentService;

@Controller
public class StudentController 
{
	
	@Autowired
	private StudentService studentService;
	
	 @PostMapping("insertstudent")
	 @ResponseBody
	 public String insertstudent(@RequestBody Student s)
	 {
		 //user nuchi student inherit cheysam
		// int userid = f.getUserid(); //auto generated kada sir
		 String firstname = s.getFirstname();
		 String lastname = s.getLastname();
		 String email = s.getEmail();
		 String password = s.getPassword();
		 String contact = s.getContact();
		 String gender = s.getGender();
		 String dob =  s.getDateOfBirth();
		 Role role =s.getRole();
		 //ekkada nuchi student class lo rasinavi 
		 String department = s.getDepartment();
		 int batchid = s.getBatchId();
		 double cgpa = s.getCgpa();
		 boolean feestatus = s.isFeestatus();
		 String parentname = s.getParentname();
		 
		 Student st =  new Student();
		 st.setFirstname(firstname);
		 st.setLastname(lastname);
		 st.setEmail(email);
		 st.setParentname(parentname);
		 st.setPassword(password);
		 st.setContact(contact);
		 st.setGender(gender);
		 st.setDateOfBirth(dob);
		 st.setRole(role);
		 st.setDepartment(department);
		 st.setBatchId(batchid);
		 st.setCgpa(cgpa);
		 st.setFeestatus(feestatus);
		
		 
		 String msg = studentService.StudentRegistration(st);
		 return msg;
	 }
	
	 
	 @PostMapping("checkstudentlogin")
	 @ResponseBody
	 public String checkStudentlogin(@RequestParam String email,@RequestParam String password)
	 {
		
	      Student student = studentService.checkstudentlogin(email, password);
	      
	      if(student!=null)
	      {
	    	  return "Student Login Successs";
	      }
	      else 
	      {
	    	  return "Student Login Failed";
	      }
		 
	 }
	 

}
