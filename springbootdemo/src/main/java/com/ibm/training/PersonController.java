package com.ibm.training;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {
	@Autowired
	PersonService pservice;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Collection<Person> getAll() {
		return pservice.getAllPerson();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public Person getPerson(@PathVariable("id")String id) {
		return pservice.getPerson(id);
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public Person insertPerson(@RequestBody Person p) {
		pservice.insertPerson(p);
		return p;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public void updatePerson(@RequestBody Person p) {
		pservice.updatePerson(p);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void deletePerson(@PathVariable("id") String id) {
		pservice.deletePerson(id);
	}
	

}
