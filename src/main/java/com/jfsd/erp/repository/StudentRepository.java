package com.jfsd.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jfsd.erp.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{
	@Query("select s from User s where s.email =?1 and s.password = ?2")
	public Student checkStudentlogin(String email , String password);
	
	@Modifying
	@Transactional
	@Query("delete from User f where f.email = ?1")
	public int deletestudentbyEmail(String email);
}
