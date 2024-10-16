package com.jfsd.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jfsd.erp.models.Admin;
import com.jfsd.erp.models.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer>
{
	@Query("select f from User f where f.email =?1 and f.password = ?2")
	public Faculty checkFacultylogin(String email , String password);
}
