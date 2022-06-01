package com.qa.SpringbootExample.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.SpringbootExample.Exception.UserNotFoundException;
import com.qa.SpringbootExample.Exception.UserNotFoundExceptionWithID;
import com.qa.SpringbootExample.domain.User;
import com.qa.SpringbootExample.repo.UserRepo;

@Service
public class UserService {

	private UserRepo repo;
	
	public UserService(UserRepo repo) {
		this.repo = repo;
	}
	

	// Create
	public User create(User user) {
		// Happens instantly
		return repo.saveAndFlush(user);
	}
	
	
	// ReadAll
	public List<User> getAll(){
		return repo.findAll();
	}
	
	
	// Read By ID
	public User getById(long id){
		// Different ways of getting the same results
		return repo.findById(id).get();
//		return repo.findById(id).orElseThrow(UserNotFoundException::new);
//		return repo.findById(id).orElseThrow(() -> new UserNotFoundExceptionWithID(id));
	}
	
	public List<User> getByFirstName(String name){
		return repo.findByFirstName(name);
	}
	
	
	
	// Update
	public User update(long id, User user){
		// get the entry that exists
		User existing = repo.findById(id).get();
		
		// Update the entry using a new object 
		existing.setFirstName(user.getFirstName());
		existing.setLastName(user.getLastName());
		existing.setUsername(user.getUsername());
		
		return repo.saveAndFlush(existing);
	}
	
	
	// Delete
	public boolean delete(long id) { 
		repo.deleteById(id);
		return !repo.existsById(id);
	}


	



	
	





	
}
