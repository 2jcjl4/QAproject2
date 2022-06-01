package com.qa.SpringbootExample.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String phoneNumber;
	

	// CONSTRUCTOR
	

	public User( String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public User(long id, String name, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	
	
	
	// GETTERS AND SETTERS
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	
	// Hash code and equals
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(phoneNumber, other.phoneNumber);
	}
	
	
	
	
}