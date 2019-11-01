package com.softapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.softapi.models.Consumer;

@Repository
public interface ConsumerRepository extends CrudRepository<Consumer,Integer>{
	
	

}
