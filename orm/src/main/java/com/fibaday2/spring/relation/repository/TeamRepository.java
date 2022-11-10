package com.fibaday2.spring.relation.repository;


import org.springframework.data.repository.CrudRepository;

import com.fibaday2.spring.entity.ProductRepository;
import com.fibaday2.spring.relation.entity.Team;

public interface TeamRepository extends CrudRepository <Team, Long> {

	
}
