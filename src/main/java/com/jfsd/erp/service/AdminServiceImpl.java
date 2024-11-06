package com.jfsd.erp.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.erp.models.Admin;
import com.jfsd.erp.models.Course;
import com.jfsd.erp.models.CourseFaculty;
import com.jfsd.erp.models.Faculty;
import com.jfsd.erp.models.Notification;
import com.jfsd.erp.models.Notification.Role;
import com.jfsd.erp.models.Section;
import com.jfsd.erp.models.Student;
import com.jfsd.erp.service.CourseService;
import com.jfsd.erp.service.FacultyService;
import com.jfsd.erp.service.SectionService;
import com.jfsd.erp.repository.AdminRepository;
import com.jfsd.erp.repository.CourseFacultyRepository;
import com.jfsd.erp.repository.CourseRepository;
import com.jfsd.erp.repository.FacultyRepository;
import com.jfsd.erp.repository.NotificationRepository;
import com.jfsd.erp.repository.SectionRepository;
import com.jfsd.erp.repository.StudentRepository;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private FacultyRepository facultyRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private NotificationRepository notificationRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private CourseFacultyRepository courseFacultyRepository;
	@Autowired
	private SectionRepository sectionRepository;
	@Autowired
	private CourseService courseService;
	@Autowired
	private FacultyService facultyService;
	@Autowired
	private SectionService sectionService;
	
	@Override
	public Admin checklogin(int userid, String pwd) {
		return  adminRepository.checklogin(userid, pwd);
	}

	@Override
	public List<Faculty> viewallfaculty() {
		return  facultyRepository.findAll();
	}

	@Override
	public List<Student> viewallstudents() {
		return studentRepository.findAll();
	}

	@Override
	public String deletefacultybyEmail(String femail) {
		facultyRepository.deletefacultybyEmail(femail);
		return "Faculty Moved to Old Staff Records Successfully";
	}
	@Override
	public String deletestudentbyEmail(String femail) {
		studentRepository.deletestudentbyEmail(femail);
		return "Student Moved to Old Student Records Successfully";
	}

//	@Override
//	public String postNotification(Role role,String message) {
//		Notification n = new Notification();
//		n.setRole(role);
//		n.setMesg(message);
//		notificationRepository.save(n);
//		return "Notification Posted Successfully";
//	}
	@Override
	public String postNotification(Notification.Role role, String message, LocalDateTime scheduledTime) {
	    Notification notification = new Notification();
	    notification.setRole(role);
	    notification.setMesg(message);
	    notification.setScheduledTime(scheduledTime);
	    notificationRepository.save(notification);
	    return "Notification Scheduled Successfully";
	}


	@Override
	public void addCourse(Course course) {
		courseRepository.save(course);
		
	}

	@Override
	public List<Course> viewCourses() {
		return courseRepository.findAll();
	}

	@Override
	public void addSection(Section section) {
		sectionRepository.save(section);
	}

	@Override
	public List<Section> viewSections() {
		return sectionRepository.findAll();
	}

	@Override
	public void assignFacultyToSection(int facultyId, int sectionId) {
		 Section section = sectionRepository.findById(sectionId).orElse(null);
	        if (section != null) {
	            CourseFaculty courseFaculty = new CourseFaculty();
	            courseFaculty.setFaculty(facultyRepository.findById(facultyId).orElse(null));
	            courseFaculty.setCourse(section.getCourse());
	            courseFaculty.setSection(section);
	            // Save the assignment
	            // Assuming you have a CourseFacultyRepository
	            courseFacultyRepository.save(courseFaculty);
	        }
		
	}

	@Override
	public void addCourseFaculty(String courseId, String facultyId, String sectionNo) {
		
		 // Find the associated entities
        Course course = courseService.findCourseById(courseId);
        Faculty faculty = facultyService.findFacultyById(facultyId);
        Section section = sectionService.findSectionByNo(sectionNo);

        // Ensure the entities are not null
        if (course == null || faculty == null || section == null) {
            throw new IllegalArgumentException("Course, Faculty, or Section not found");
        }

        // Create a new CourseFaculty object and set its properties
        CourseFaculty courseFaculty = new CourseFaculty();
        courseFaculty.setCourse(course);
        courseFaculty.setFaculty(faculty);
        courseFaculty.setSection(section);
        
        if (courseFacultyRepository.existsByCourse(section.getCourse())) {
            throw new IllegalArgumentException("This course is already assigned to another faculty.");
        }

        // Save the CourseFaculty entity
        courseFacultyRepository.save(courseFaculty);
    }

	
}
