package com.jfsd.erp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfsd.erp.models.Enrollment;
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer>{
	List<Enrollment> findByStudent_UserStuId(int userStuId);
	
}
