package com.qa.SpringbootExample.controllers;


import java.util.List;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.SpringbootExample.Services.CreatureService;

import com.qa.SpringbootExample.domain.Creature;


@CrossOrigin
@RestController
@RequestMapping("/creature")
public class CreatureController {

	private CreatureService service;
	
	public CreatureController(CreatureService service) {
		this.service = service;
	}
	// Get all
	@GetMapping("/getAll")
	public ResponseEntity<List<Creature>> getAll(){
		return new ResponseEntity<List<Creature>>(service.getAll(), HttpStatus.OK);
	}
	
	// Create
	@PostMapping("/create")
	public ResponseEntity<Creature> create(@RequestBody Creature creature) {
		return new ResponseEntity<Creature>(service.create(creature), HttpStatus.CREATED);
	}
	
	
	
	// Update 
	@PutMapping("/update/{id}")
	public ResponseEntity<Creature> update(@PathVariable long id, @RequestBody Creature creature){
		return new ResponseEntity<Creature>(service.update(id, creature), HttpStatus.ACCEPTED);
	}
	
	
	
	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) { 
		return service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
}
