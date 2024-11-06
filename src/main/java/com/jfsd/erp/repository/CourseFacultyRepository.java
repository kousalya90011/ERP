package com.jfsd.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfsd.erp.models.CourseFaculty;
import com.jfsd.erp.models.Course;


@Repository
public interface CourseFacultyRepository extends JpaRepository<CourseFaculty, Integer>{

	boolean existsByCourse(Course course);

}
