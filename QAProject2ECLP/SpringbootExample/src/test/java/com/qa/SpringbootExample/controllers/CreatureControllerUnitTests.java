package com.qa.SpringbootExample.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.SpringbootExample.Services.CreatureService;
import com.qa.SpringbootExample.domain.Creature;

@WebMvcTest
public class CreatureControllerUnitTests {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private CreatureService service;
	
	
	@Test
	void createTest() throws Exception {
		Creature entry = new Creature("Creature2",22,22,22,"Notes2");
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Mockito.when(service.create(entry)).thenReturn(entry);
		
		mvc.perform(post("/creature/create")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(status().isCreated())
			.andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void getAllTest() throws Exception {
		Creature entry = new Creature("Creature2",22,22,22,"Notes2");
		List<Creature> output = new ArrayList<>();
		output.add(entry);
		String outputAsJSON = mapper.writeValueAsString(output);
		
		Mockito.when(this.service.getAll()).thenReturn(output);
		
		mvc.perform(get("/creature/getAll")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(outputAsJSON));
	}
	

	@Test
	public void updateTest() throws Exception {
		Creature entry = new Creature("Creature2",22,22,22,"Notes2");
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Mockito.when(this.service.update(1L, entry)).thenReturn(entry);
		
		mvc.perform(put("/creature/update/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(status().isAccepted())
			.andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void deleteTest() throws Exception {
		Mockito.when(service.delete(1L)).thenReturn(true);
	
		mvc.perform(delete("/creature/delete/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNoContent());
	}
	
	@Test
	public void deleteFailTest() throws Exception {
		Mockito.when(service.delete(1L)).thenReturn(false);
	
		mvc.perform(delete("/creature/delete/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound());
	}
	
}
