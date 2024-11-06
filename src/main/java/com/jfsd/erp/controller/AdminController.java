package com.jfsd.erp.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jfsd.erp.models.Admin;
import com.jfsd.erp.models.Faculty;
import com.jfsd.erp.models.Notification;
import com.jfsd.erp.models.Student;
import com.jfsd.erp.service.AdminService;

@Controller
@ResponseBody
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/")
	public ModelAndView adminhome()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminhome");
		return mv;
	}
	
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
	 @GetMapping("viewallfacultypage")
		public ModelAndView viewallfacultypage()
		{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("viewallfacultypage");
			return mv;
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
	 @GetMapping("deletestudent")
	 public String deletestudentbyId(@RequestParam("email") String femail)
	 {
		 return adminService.deletestudentbyEmail(femail);
	 }
	 @GetMapping("postnotification")
		public ModelAndView postnotification()
		{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("postnotification");
			return mv;
		}
	 
		/*
		 * @PostMapping("notification")
		 * 
		 * @ResponseBody public String PostNotification(@RequestParam("role") Role
		 * role, @RequestParam("mesg") String message) { String msg = message; Role
		 * role1 =role; String result = adminService.postNotification(role1,msg); return
		 * result; }
		 */
	 @PostMapping("notification")
	 @ResponseBody
	 public String postNotification(@RequestBody Notification notification) {
	     String result = adminService.postNotification(notification.getRole(), notification.getMesg(), notification.getScheduledTime());
	     return result;
	 }


	 
	
	 
	 
	 

}
