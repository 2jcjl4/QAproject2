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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.SpringbootExample.domain.Creature;


@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class CreatureControllerIntegrationTests {
		@Autowired
		private MockMvc mvc;
		@Autowired
		private ObjectMapper mapper;

		
		@Test
		public void createTest() throws Exception {
			Creature input = new Creature("Creature2",22,22,22,"Notes2");
			String inputAsJSON = mapper.writeValueAsString(input);
			
			Creature output = new Creature(2L, "Creature2",22,22,22,"Notes2");
			String outputAsJSON = mapper.writeValueAsString(output);
			
			mvc.perform(post("/creature/create")
					.contentType(MediaType.APPLICATION_JSON)
					.content(inputAsJSON))
					.andExpect(status().isCreated())
					.andExpect(content().json(outputAsJSON)); 
		}
	
		
		@Test
		public void updateTest() throws Exception {
			Creature entry = new Creature("Creature1",11,11,11,"Notes1");
			Creature result = new Creature(1L, "Creature1",11,11,11,"Notes1");
			
			String entryAsJSON = this.mapper.writeValueAsString(entry);
			String resultAsJSON = this.mapper.writeValueAsString(result);
			
			mvc.perform(put("/creature/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isAccepted())
				.andExpect(content().json(resultAsJSON));
		}
	
		@Test
		public void getAllTest() throws Exception {
			Creature creature = new Creature(1L, "Creature1",11,11,11,"Notes1");
			List<Creature> output = new ArrayList<>();
			output.add(creature);
			
			String outputAsJSON = mapper.writeValueAsString(output);
			
			mvc.perform(get("/creature/getAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(outputAsJSON));
		}
		
		@Test
		public void deleteTest() throws Exception {
			mvc.perform(delete("/creature/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
		}
}

