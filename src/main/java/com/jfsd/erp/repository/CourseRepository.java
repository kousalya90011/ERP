package com.jfsd.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfsd.erp.models.Course;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	public Course findByCourseCode(String courseCode);
	boolean existsByCourseId(int courseId);

}
