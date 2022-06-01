package com.qa.SpringbootExample.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.SpringbootExample.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	// Derived Query
	// Select * from user WHERE firstname == firstName
	List<User> findByFirstName(String firstName);
	
	// Manual SQL Query
	@Query(value = "SELECT * FROM userWHERE username = ?1", nativeQuery=true)
	Optional<User> findByUsername(String username, String firstName, String lastName);
}
