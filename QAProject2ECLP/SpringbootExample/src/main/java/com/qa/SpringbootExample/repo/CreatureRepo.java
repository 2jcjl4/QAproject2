package com.qa.SpringbootExample.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.SpringbootExample.domain.Creature;


@Repository
public interface CreatureRepo extends JpaRepository<Creature, Long>{

}
