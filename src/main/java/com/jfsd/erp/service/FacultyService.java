package com.jfsd.erp.service;

import com.jfsd.erp.models.Faculty;

public interface FacultyService {
public String FacultyRegistration(Faculty f);
public Faculty checklogin(String email,String password);
}
