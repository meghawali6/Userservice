package com.userservice.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.mongodb.model.User;
import com.userservice.mongodb.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository personRepository;
	
	//Create operation
	public User create(String firstName,String lastName, int age) {
		return personRepository.save(new User(firstName, lastName, age));
	}
	//Retrieve operation
	public List<User> getAll(){
		return personRepository.findAll();
	}
	public User getByFirstName(String firstName) {
		return personRepository.findByFirstName(firstName);
	}
	//Update operation
	public User update(String firstName, String lastName, int age) {
		User p = personRepository.findByFirstName(firstName);
		p.setLastName(lastName);
		p.setAge(age);
		return personRepository.save(p);
	}
	//Delete operation
	public void deleteAll() {
		personRepository.deleteAll();
	}
	public void delete(String firstName) {
		User p = personRepository.findByFirstName(firstName);
		personRepository.delete(p);
	}
}

