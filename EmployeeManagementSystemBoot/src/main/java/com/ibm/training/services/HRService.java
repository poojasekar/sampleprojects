package com.ibm.training.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.training.daoimpl.DaoImpl;
import com.ibm.training.dto.Holiday;
import com.ibm.training.dto.User;

@Service
public class HRService {
	
	@Autowired
	DaoImpl hrDaoImpl;
	
	public User viewProfile(String uname) {
		return hrDaoImpl.viewProfile(uname);
	}
	
	public Collection<User> viewEmpDetails(String uname) {
		return hrDaoImpl.viewEmpDetail(uname);
	}
	
	public int applyLeave(int id,  int leave) {
		return hrDaoImpl.applyLeave(id, leave);
	}
	
	public Collection<Holiday> leaveRequests(String uname) {
		return hrDaoImpl.leaveRequest(uname);
	}
	
	public Collection<Holiday> leaveRecord(String ename) {
		return hrDaoImpl.leaveRequest(ename);
	}

}
