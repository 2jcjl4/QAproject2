package com.qa.SpringbootExample.Services;


import java.util.List;

import org.springframework.stereotype.Service;
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
		return repo.saveAndFlush(user);
	}
	
	
	// ReadAll
	public List<User> getAll(){
		return repo.findAll();
	}
	
	
	
	// Update
	public User update(long id, User user){
		
		// get the entry that exists
		User existing = repo.findById(id).get();
		
		// Update the entry using a new object 
		existing.setName(user.getName());
		existing.setPhoneNumber(user.getPhoneNumber());
		
		return repo.saveAndFlush(existing);
	}
	
	
	// Delete
	public boolean delete(long id) { 
		repo.deleteById(id);
		return !repo.existsById(id);
	}


	



	
	





	
}
