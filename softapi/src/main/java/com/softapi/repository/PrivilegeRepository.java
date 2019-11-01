package com.softapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.softapi.models.Privilege;


@Repository
public interface PrivilegeRepository extends CrudRepository<Privilege,Integer>{

	
	@Query(value="select * from privilege where name=:name",nativeQuery=true)
	Privilege getPrivilegeByName(@Param("name") String name);
}
