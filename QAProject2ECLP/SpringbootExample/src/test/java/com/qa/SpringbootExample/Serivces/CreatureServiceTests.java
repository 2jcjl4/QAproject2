package com.qa.SpringbootExample.Serivces;

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
import org.springframework.test.context.ActiveProfiles;

import com.qa.SpringbootExample.Services.CreatureService;
import com.qa.SpringbootExample.domain.Creature;
import com.qa.SpringbootExample.repo.CreatureRepo;

@SpringBootTest
@ActiveProfiles("test")
public class CreatureServiceTests {

	
	@Autowired
	private CreatureService service;

	@MockBean
	private CreatureRepo repo;

	
	@Test
	public void updateTest() {
		Creature input = new Creature("Creature4",11,12,11,"notesss1");
		Optional<Creature> existing = Optional.of(new Creature(1L, "Creature1",11,11,11,"notes1"));
		Creature output = new Creature(1L,"Creature4",11,12,11,"notesss1");

		Mockito.when(repo.findById(1L)).thenReturn(existing);
		Mockito.when(repo.saveAndFlush(output)).thenReturn(output);
		assertEquals(output, service.update(1L, input));
		Mockito.verify(repo, Mockito.times(1)).saveAndFlush(output);
		Mockito.verify(repo, Mockito.times(1)).findById(1L);
	}


	@Test
	public void getAllTest() {
		List<Creature> output = new ArrayList<>();
		output.add(new Creature(1L, "Creature1",11,11,11,"notes1"));
		
		Mockito.when(repo.findAll()).thenReturn(output);
		assertEquals(output, service.getAll());
		Mockito.verify(repo, Mockito.times(1)).findAll(); 
	}

	
	@Test
	public void createTest() {
		Creature input = new Creature("Creature1",11,11,11,"notes1");
		Creature output = new Creature(1L, "Creature1",11,11,11,"notes1");
		
		Mockito.when(repo.saveAndFlush(input)).thenReturn(output);
		assertEquals(output, service.create(input));
		Mockito.verify(repo, Mockito.times(1)).saveAndFlush(input);
	}



}
