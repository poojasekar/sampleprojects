package com.ibm.training.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.training.dto.User;
import com.ibm.training.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService aservice;
	
	@RequestMapping(value="/profile/{uname}",method=RequestMethod.GET)
	public User viewAdmin(@PathVariable("uname") String uname) {
		User admin=aservice.viewProfile(uname);
		return admin;
	}
	
	@RequestMapping(value="/viewall",method=RequestMethod.GET)
	public Collection<User> viewDeta() {
		Collection<User> employees=aservice.viewDetails();
		return employees;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public int addDetails(@RequestBody User user) {
		return aservice.addDetails(user);
	}
	
	@RequestMapping(value="/update/{e_id}/{cno}/{address}/{salary}",method=RequestMethod.PUT)
	public int updateEmployee(@PathVariable("e_id") int e_id,@PathVariable("cno") String cno,@PathVariable("address") String address,@PathVariable("salary") String salary) {
		return aservice.updateDetails(e_id,cno,address,salary);
		
	}
	
	@RequestMapping(value="/delete/{e_id}",method=RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("e_id") int e_id) {
		aservice.deleteUser(e_id);		
	}

}
