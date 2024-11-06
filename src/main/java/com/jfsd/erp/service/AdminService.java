package com.jfsd.erp.service;

import java.time.LocalDateTime;
import java.util.List;

import com.jfsd.erp.models.Admin;
import com.jfsd.erp.models.Course;
import com.jfsd.erp.models.Faculty;
import com.jfsd.erp.models.Notification;
import com.jfsd.erp.models.Notification.Role;
import com.jfsd.erp.models.Section;
import com.jfsd.erp.models.Student;

public interface AdminService 
{
	public Admin checklogin(int userid, String pwd);
	public List<Faculty> viewallfaculty();
	public List<Student> viewallstudents();
	public String deletefacultybyEmail(String femail);
	public String deletestudentbyEmail(String femail);
	public String postNotification(Notification.Role role, String message, LocalDateTime scheduledTime);
	
	public void addCourse(Course course);
	public List<Course> viewCourses();
	public void addSection(Section section);
	public List<Section> viewSections() ;
	public void assignFacultyToSection(int facultyId, int sectionId);
	public void addCourseFaculty(String courseCode, String facultyId, String sectionNo);

}
