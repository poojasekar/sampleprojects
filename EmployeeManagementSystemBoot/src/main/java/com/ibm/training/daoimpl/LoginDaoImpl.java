package com.ibm.training.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ibm.training.dto.User;

@Repository
public class LoginDaoImpl {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public User validLogin(User u) {
		String sql="select * from user where uname=? and pwd=?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),u.getUname(),u.getPwd());
	}
}
