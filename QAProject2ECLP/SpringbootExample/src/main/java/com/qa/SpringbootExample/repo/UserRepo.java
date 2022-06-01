package com.qa.SpringbootExample.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.SpringbootExample.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}