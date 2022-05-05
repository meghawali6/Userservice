package com.userservice.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.mongodb.model.User;
import com.userservice.mongodb.service.UserService;

@RestController
public class UserContoller {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/create")
	public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
		User p = userService.create(firstName, lastName, age);
		return p.toString();
	}
	
	@RequestMapping("/get")
	public User getPerson(@RequestParam String firstName) {
		return userService.getByFirstName(firstName);
	}
	@RequestMapping("/getAll")
	public List<User> getAll(){
		return userService.getAll();
	}
	@RequestMapping("/update")
	public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
		User p = userService.update(firstName, lastName, age);
		return p.toString();
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam String firstName) {
		userService.delete(firstName);
		return "Deleted "+firstName;
	}
	@RequestMapping ("/deleteAll")
	public String deleteAll() {
		userService.deleteAll();
		return "Deleted all records";
	}
	
}
