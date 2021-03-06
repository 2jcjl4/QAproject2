package com.qa.SpringbootExample.Services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.SpringbootExample.domain.Creature;
import com.qa.SpringbootExample.repo.CreatureRepo;


@Service
public class CreatureService {

	private CreatureRepo repo;
	
	public CreatureService(CreatureRepo repo) {
		this.repo = repo;
	}
	

	// Create
	public Creature create(Creature creature) {
		return repo.saveAndFlush(creature);
	}
	
	
	// ReadAll
	public List<Creature> getAll(){
		return repo.findAll();
	}
	
	
	
	// Update
	public Creature update(long id, Creature creature){
		
		// get the entry that exists
		Creature existing = repo.findById(id).get();
		
		// Update the entry using a new object 
		existing.setName(creature.getName());
		existing.setHealth(creature.getHealth());
		existing.setDamage(creature.getDamage());
		existing.setSpeed(creature.getSpeed());
		existing.setNotes(creature.getNotes());
		
		return repo.saveAndFlush(existing);
	}
	
	
	// Delete
	public boolean delete(long id) { 
		repo.deleteById(id);
		return !repo.existsById(id);
	}


	



	
	





	
}
