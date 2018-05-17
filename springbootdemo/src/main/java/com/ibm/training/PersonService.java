package com.ibm.training;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository prep;
	//Hashtable<String, Person> ht=new Hashtable<>();
	public PersonService() {
		/*Person p=new Person("1","Pooja","Sekar",22);
		Person p1=new Person("2","Pragati","Ghodake",22);
		Person p2=new Person("3","Shaili","Singh",22);
		Person p3=new Person("4","Ashwini","Deshmukh",22);
		ht.put("1", p);
		ht.put("2", p1);
		ht.put("3", p2);
		ht.put("4", p3);*/
	}
	
	public Collection<Person> getAllPerson() {
		return prep.findAllPersons();
	}
	
	public Person getPerson(String id) {
		return prep.findPerson(id);
	}
	
	public void insertPerson(Person p) {
		 prep.insertPerson(p);
	}
	
	public void updatePerson(Person p) {
		prep.updatePerson(p);
	}
	
	public void deletePerson(String id) {
		prep.deletePerson(id);
	}

}
