package com.ibm.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.training.dto.Holiday;
import com.ibm.training.dto.User;
import com.ibm.training.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService eservice;
	
	@RequestMapping("/profile/{uname}")
	public User viewProfile(@PathVariable("uname") String uname) {
		return eservice.viewProfile(uname);
	}
	
	@RequestMapping("/applyleave")
	public void applyLeave(@RequestBody Holiday holiday) {
		eservice.applyLeave(holiday.getE_id(),holiday.getNo_of_days());
	}
	
	@RequestMapping("/leaverecord")
	public List<Holiday> leaveRecord(String uname) {
		return eservice.leaveRecord(uname);
	}


}
