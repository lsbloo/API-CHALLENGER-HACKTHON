package com.softapi.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.softapi.models.User;



@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
	
	@Query(value="select * from userr where username=:username",nativeQuery=true)
	User checkIfUserExist(@Param("username") String username);
	

}
