package com.jfsd.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jfsd.erp.models.Faculty;
import com.jfsd.erp.models.User.Role;
import com.jfsd.erp.service.FacultyService;

@Controller
@ResponseBody
@RequestMapping("/faculty")
public class FacultyController 
{
	@Autowired
	FacultyService facultyService;
	
	
	@PostMapping("insertfaculty")
	 @ResponseBody
	 public String insertfaculty(@ModelAttribute Faculty f)
	 {
		// int userid = f.getUserid();
		 //inherited from user
		 String firstname =f.getFirstname();
		 String lastname = f.getLastname();
		 String email = f.getEmail();
		 String password = f.getPassword();
		 String contact = f.getContact();
		 String gender = f.getGender();
		 String dob =  f.getDateOfBirth();
		 Role role =f.getRole();
		 //faculty 
		 String department = f.getDepartment();
		 String designation = f.getDesignation();
		 double salary = f.getSalary();
		 String reg_status=f.getReg_status();
		 
		 Faculty fac = new Faculty();
		 //fac.setUserid(userid);
		 fac.setFirstname(firstname);
		 fac.setLastname(lastname);
		 fac.setEmail(email);
		 fac.setPassword(password);
		 fac.setContact(contact);
		 fac.setGender(gender);
		 fac.setDateOfBirth(dob);
		 fac.setRole(role);
		 fac.setDepartment(department);
		 fac.setDesignation(designation);
		 fac.setSalary(salary);
		 fac.setReg_status(reg_status);
		 
		 String facultyId = fac.generateFacultyId();
		    fac.setFacultyId(facultyId);

		    // Register the faculty via the service
		    String msg = facultyService.FacultyRegistration(fac);

		    return msg + " with Faculty ID: " + facultyId;
	 }
	 
	 @PostMapping("checkfacultylogin")
	 public String checkFacultylogin(@RequestParam String email,@RequestParam String password)
	 {
		
	      Faculty faculty = facultyService.checklogin(email, password);
	      
	      if(faculty!=null)
	      {
	    	  return "Faculty Login Successs";
	      }
	      else 
	      {
	    	  return "Faculty Login Failed";
	      }
		 
	 }
	 
}
