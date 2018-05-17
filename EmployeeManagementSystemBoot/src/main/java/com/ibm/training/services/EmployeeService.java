package com.ibm.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.training.daoimpl.DaoImpl;
import com.ibm.training.dto.Holiday;
import com.ibm.training.dto.User;

@Service
public class EmployeeService {
	
	@Autowired
	DaoImpl empDaoImpl;
	
	public User viewProfile(String uname) {
		return empDaoImpl.viewProfile(uname);
	}
	
	public int applyLeave(int id, int leave) {
		return empDaoImpl.applyLeave(id, leave);
	}
	
	public List<Holiday> leaveRecord(String uname) {
		return empDaoImpl.leaveRequest(uname);
	}


}
