package com.qa.SpringbootExample.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.qa.SpringbootExample.Services.CreatureService;
import com.qa.SpringbootExample.domain.Creature;
import com.qa.SpringbootExample.repo.CreatureRepo;


@SpringBootTest
public class CreatureControllerIntegrationTests {
	@Autowired
	private CreatureService service;
	
	@MockBean CreatureRepo repo;
	
	
	
	
	@Test
	public void getAllTest() {
		List<Creature> output = new ArrayList<>();
		output.add(new Creature(1L,"Creature1",12,12,12,"extranote"));
		
		Mockito.when(repo.findAll()).thenReturn(output);
		
		assertEquals(output, service.getAll());
		
		Mockito.verify(repo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void createTest() {
		Creature input = new Creature("Creature1",12,12,12,"extranote");
		Creature output = new Creature(1L,"Creature1",12,12,12,"extranote");
		
		Mockito.when(repo.saveAndFlush(input)).thenReturn(output);
		
		assertEquals(output, service.create(input));
		
		Mockito.verify(repo, Mockito.times(1)).saveAndFlush(input);
	}
	
	@Test
	public void updateTest() {
		// Creating any expected output and inputs if necessary
		Creature input = new Creature("Creature1",12,12,12,"extranote");
		Optional<Creature> existing = Optional.of(new Creature(1L,"Creature1",12,12,12,"extranote"));
		Creature output = new Creature(1L,"Creature1",12,12,12,"extranote");
		
		// Mocking the dependency (repo)
		Mockito.when(repo.findById(1L)).thenReturn(existing);
		Mockito.when(repo.saveAndFlush(output)).thenReturn(output);
		
		// Asserting the actual test method's output
		assertEquals(output, service.update(1L, input));
		
		// Verifying the number of times a mock method ran - Not Required
		Mockito.verify(repo, Mockito.times(1)).saveAndFlush(output);
		Mockito.verify(repo, Mockito.times(1)).findById(1L);
	}


}
