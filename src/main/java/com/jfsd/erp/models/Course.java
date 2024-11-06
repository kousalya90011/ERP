package com.jfsd.erp.models;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_name", nullable = false)
    private String courseName;
    
    @Column(name="course_code",nullable=false,unique=true)
    private String courseCode;
    
    @Column(name="course_desc",nullable=false)
    private String courseDesc;
    
    @Column(name="course_credits",nullable=false)
    private String courseCredits;


    @ManyToMany(mappedBy = "courses")  // Updated to "courses" to match Faculty entity property
    private Set<Faculty> faculty;

    @ManyToMany(mappedBy = "courses")  // Assuming Student has a Set<Course> courses property
    private Set<Student> students;

    @ManyToMany
    @JoinTable(
        name = "course_section",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "section_id")
    )
    private Set<Section> sections;
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Faculty> getFaculty() {
		return faculty;
	}

	public void setFaculty(Set<Faculty> faculty) {
		this.faculty = faculty;
	}

	public Set<Section> getSections() {
		return sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	public String getCourseCredits() {
		return courseCredits;
	}

	public void setCourseCredits(String courseCredits) {
		this.courseCredits = courseCredits;
	}

    // Getters and Setters
}
