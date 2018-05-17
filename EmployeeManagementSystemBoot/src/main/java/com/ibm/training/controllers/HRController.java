package com.ibm.training.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.training.dto.Holiday;
import com.ibm.training.dto.User;
import com.ibm.training.services.HRService;

@RestController
@RequestMapping("/hr")
public class HRController {
	
	@Autowired
	HRService hservice;
	
	@RequestMapping("/profile")
	public User viewProfile(@RequestBody String uname) {
		return hservice.viewProfile(uname);
	}
	
	@RequestMapping("/view")
	public Collection<User> viewEmpDetails(@RequestBody String uname) {
		return hservice.viewEmpDetails(uname);
	}
	
	@RequestMapping("/applyleave")
	public int applyLeave(@RequestBody int id, int leave) {
		return hservice.applyLeave(id, leave);
	}
	
	@RequestMapping("/leaverequests")
	public Collection<Holiday> leaveRequests(@RequestBody String uname) {
		return hservice.leaveRequests(uname);
	}
	
	@RequestMapping("/leaverecord")
	public Collection<Holiday> leaveRecord(String ename) {
		return hservice.leaveRecord(ename);
	}

}
