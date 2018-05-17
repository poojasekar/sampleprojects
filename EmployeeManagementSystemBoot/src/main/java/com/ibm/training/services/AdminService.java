package com.ibm.training.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.training.daoimpl.DaoImpl;
import com.ibm.training.dto.User;

@Service
public class AdminService {
	
	@Autowired
	DaoImpl adminDao;
	
	public Collection<User> viewDetails() {
		return adminDao.findAllUsers();
	}
	
	public int addDetails(User user) {
		return adminDao.addDetails(user);
	}
	
	public int updateDetails(int e_id,String cno,String address,String salary) {
		return adminDao.editById(e_id,cno,address,salary);
	}
	
	public void deleteUser(int e_id) {
		adminDao.removeUser(e_id);
	}

	public User viewProfile(String uname) {
		return adminDao.viewProfile(uname);
	}

}
