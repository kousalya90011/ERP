package com.jfsd.erp.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jfsd.erp.models.Admin;
import com.jfsd.erp.models.Faculty;
import com.jfsd.erp.models.Student;
import com.jfsd.erp.models.User.Role;
import com.jfsd.erp.service.AdminService;
import com.jfsd.erp.service.FacultyService;
import com.jfsd.erp.service.StudentService;

@Controller
public class MainController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	@ResponseBody
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	
	
	
	

}
