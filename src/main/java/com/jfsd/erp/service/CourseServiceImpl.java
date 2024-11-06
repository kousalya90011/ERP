package com.jfsd.erp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.erp.models.Course;
import com.jfsd.erp.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
    private CourseRepository courseRepository;

    // Method to find a course by its ID
	@Override
    public Course findCourseById(String courseId) {
        // Use the repository to find the course
        Course course = courseRepository.findByCourseCode(courseId);
        return course; // Return the course if found, or null if not found
    }

}
