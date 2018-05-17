package com.ibm.training.controllers;

import java.io.IOException;


import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.training.dto.User;
import com.ibm.training.services.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/{uname}/{pwd}")
	public String validLogin(HttpServletResponse response,
			@PathVariable("uname")String uname,@PathVariable("pwd")String pwd) throws IOException {
		User u=new User();
		u.setUname(uname);
		u.setPwd(pwd);
		System.out.println("user"+u.getUname());
	u=	loginService.validLogin(u);
	System.out.println("role"+u.getRole());
	String role=u.getRole();
			
	return role;
		
	}
	

}
