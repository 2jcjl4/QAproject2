package com.qa.SpringbootExample.Exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundExceptionWithID extends EntityNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7490906423900817228L;

	// can do all this front end but this is for learning
	public UserNotFoundExceptionWithID(long id) {
		super("User does not exist with ID; " + id);
		
	}
	
	
}
