package com.jfsd.erp.service;

import com.jfsd.erp.models.Admin;

public interface AdminService 
{
	public Admin checklogin(int userid, String pwd);
}
