package com.jfsd.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.erp.models.Admin;
import com.jfsd.erp.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin checklogin(int userid, String pwd) {
		return  adminRepository.checklogin(userid, pwd);
	}
}
