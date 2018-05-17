package com.ibm.training;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Collection<Person> findAllPersons() {
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person findPerson(String id) {
		return jdbcTemplate.queryForObject("select * from person where id=?", new BeanPropertyRowMapper<Person>(Person.class),id);
	}
	
	public void insertPerson(Person person) {
		 jdbcTemplate.update("insert into person values(?,?,?,?)",
				person.getId(),person.getFirstName(),person.getLastName(),person.getAge());
	}
	
	public void updatePerson(Person person) {
		String sql="update person set firstName=?, lastName=?, age=? where id=?";
		jdbcTemplate.update(sql, person.getFirstName(),person.getLastName(),person.getAge(),person.getId());
	}
	
	public void deletePerson(String id) {
		jdbcTemplate.update("delete from person where id=?",id);
	}

}
