package com.qa.SpringbootExample.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Creature {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Integer health;
	
	@Column(nullable = false)
	private Integer damage;
	
	@Column(nullable = false)
	private Integer speed;
	
	@Column(nullable = false)
	private String notes;
	
	
	
	

	// CONSTRUCTOR


	public Creature() {
	}

	public Creature(String name, Integer health, Integer damage, Integer speed, String notes) {
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.speed = speed;
		this.notes = notes;
	}

	

	public Creature(long id, String name, Integer health, Integer damage, Integer speed, String notes) {
		this.id = id;
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.speed = speed;
		this.notes = notes;
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


	public Integer getHealth() {
		return health;
	}


	public void setHealth(Integer health) {
		this.health = health;
	}


	public Integer getDamage() {
		return damage;
	}


	public void setDamage(Integer damage) {
		this.damage = damage;
	}


	public Integer getSpeed() {
		return speed;
	}


	public void setSpeed(Integer speed) {
		this.speed = speed;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}



	// Hash code and equals
	
	@Override
	public int hashCode() {
		return Objects.hash(damage, health, id, name, notes, speed);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Creature other = (Creature) obj;
		return Objects.equals(damage, other.damage) && Objects.equals(health, other.health) && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(notes, other.notes)
				&& Objects.equals(speed, other.speed);
	}

	
	
	
	
	
}
