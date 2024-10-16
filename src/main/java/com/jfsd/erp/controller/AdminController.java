package com.jfsd.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jfsd.erp.models.Admin;
import com.jfsd.erp.service.AdminService;
import com.jfsd.erp.service.AdminServiceImpl;

@Controller
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	
	 @PostMapping("checkadminlogin")
     @ResponseBody
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
	 

}
