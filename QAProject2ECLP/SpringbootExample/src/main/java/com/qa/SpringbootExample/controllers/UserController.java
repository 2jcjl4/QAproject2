package com.qa.SpringbootExample.controllers;


import java.util.List;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.SpringbootExample.Services.UserService;
import com.qa.SpringbootExample.domain.User;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	// Get all
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAll(){
		return new ResponseEntity<List<User>>(service.getAll(), HttpStatus.OK);
	}
	
	// Create
	@PostMapping("/create")
	public ResponseEntity<User> create(@RequestBody User user) {
		return new ResponseEntity<User>(service.create(user), HttpStatus.CREATED);
	}
	
	
	
	// Update 
	@PutMapping("/update/{id}")
	public ResponseEntity<User> update(@PathVariable long id, @RequestBody User user){
		return new ResponseEntity<User>(service.update(id, user), HttpStatus.ACCEPTED);
	}
	
	
	
	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) { 
		return service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
}