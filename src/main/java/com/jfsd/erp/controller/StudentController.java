package com.jfsd.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jfsd.erp.models.Enrollment;
import com.jfsd.erp.models.Student;
import com.jfsd.erp.models.User.Role;
import com.jfsd.erp.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("sections", studentService.getAvailableSections());
        return "register"; // JSP view name
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Enrollment enrollment) {
        studentService.register(enrollment);
        return "redirect:/student/dashboard";
    }
    @PostMapping("insertstudent")
	 @ResponseBody
	 public String insertstudent(@ModelAttribute Student s)
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
		 boolean feestatus = s.isFeeStatus();
		 String parentname = s.getParentName();
		 int joinyear=s.getJoinyear();
		 
		 Student st =  new Student();
		 st.setFirstname(firstname);
		 st.setLastname(lastname);
		 st.setEmail(email);
		 st.setParentName(parentname);
		 st.setPassword(password);
		 st.setContact(contact);
		 st.setGender(gender);
		 st.setDateOfBirth(dob);
		 st.setRole(role);
		 st.setDepartment(department);
		 st.setBatchId(batchid);
		 st.setCgpa(cgpa);
		 st.setFeeStatus(feestatus);
		 st.setJoinyear(joinyear);
		 st.setStudentId(st.generateStudentId(department, joinyear));
		 

		    String msg = studentService.StudentRegistration(st);

		    return msg + " with Student ID: " + st.getStudentId();
	 }
	 
}
