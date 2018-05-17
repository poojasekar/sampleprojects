package com.ibm.training.daoimpl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ibm.training.dto.Holiday;
import com.ibm.training.dto.User;

@Repository
public class DaoImpl {
	
		@Autowired
		private JdbcTemplate jdbcTemplate;
		
		public int addDetails(User user) {
			return jdbcTemplate.update("insert into user(e_name,d_id,hr_id,dob,c_no,address,gender,doj,loc,role,uname,pwd,sal,dpt) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
						user.getE_name(),user.getD_id(),user.getHr_id(),user.getDob(),user.getC_no(),user.getAddress(),user.getGender(),
							user.getDoj(),user.getLoc(),user.getRole(),user.getUname(),user.getPwd(),user.getSal(),user.getDpt());
		}
		
		public Collection<User> findAllUsers(){
			return jdbcTemplate.query("select * from user",
					new BeanPropertyRowMapper<User>(User.class));
		}	
		
		public int removeUser(int e_id){
			return jdbcTemplate.update("delete from user where e_id= ? ",e_id);
		}

		public int editById(int e_id,String cno,String address,String salary) {
			return jdbcTemplate.update("update user set c_no=?,address=?,sal=? where e_id=?",cno,address,salary,e_id);
		}	
		
		public User viewProfile(String uname){
			return jdbcTemplate.queryForObject("select * from user where uname=?",
					new BeanPropertyRowMapper<User>(User.class),uname);
		}
		
		public Collection<User> viewEmpDetail(String uname){
			return jdbcTemplate.query("select * from user where role='Employee' or role='HR' and hr_id=(select e_id from user where uname=?)",
					new BeanPropertyRowMapper<User>(User.class),uname);
		}
		
		public int applyLeave(int id,int leave){
			return jdbcTemplate.update("insert into holiday(emp_id,no_of_leaves,status) values(?,?,'N')",id,leave);
		}	
		
		public List<Holiday> leaveRequest(String uname){
			return jdbcTemplate.query("select emp_id,e_name,no_of_leaves from holiday inner join user where hr_id=(select hr_id from user where uname=?) and user.e_id=holiday.emp_id",new BeanPropertyRowMapper<Holiday>(Holiday.class),uname);
		}
		
	}
