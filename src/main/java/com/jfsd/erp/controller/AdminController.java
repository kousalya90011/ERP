package com.jfsd.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jfsd.erp.models.Admin;
import com.jfsd.erp.models.Faculty;
import com.jfsd.erp.models.Student;
import com.jfsd.erp.service.AdminService;
import com.jfsd.erp.service.AdminServiceImpl;

@Controller
@ResponseBody
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	
	 @PostMapping("checkadminlogin")
     public String checkadminlogin(@RequestBody Admin a)
     {
    	 
      int auid = a.getUserid();
      String apwd = a.getPwd();
      Admin admin = adminService.checklogin(auid, apwd);
      
      if(admin!=null)
      {
    	  return "Admin Login Successs";
      }
      else 
      {
    	  return "Admin Login Failed";
      }
     }
	 
	 @GetMapping("viewallfaculty")
	 public List<Faculty> viewallfaculty()
	 {
		return adminService.viewallfaculty();
	 }
	 
	 @GetMapping("viewallstudents")
	 public List<Student> viewallstudents()
	 {
		return adminService.viewallstudents();
	 }
	 @GetMapping("deletefaculty")
	 public String deletefacultybyId(@RequestParam("email") String femail)
	 {
		 return adminService.deletefacultybyEmail(femail);
	 }
	 

}
