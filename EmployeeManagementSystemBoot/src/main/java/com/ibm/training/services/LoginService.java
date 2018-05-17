package com.ibm.training.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.training.daoimpl.LoginDaoImpl;
import com.ibm.training.dto.User;

@Service
public class LoginService {

	@Autowired
	LoginDaoImpl loginDaoImpl;
	
	public User validLogin(User u)
	{
		return loginDaoImpl.validLogin(u);
	}
}
