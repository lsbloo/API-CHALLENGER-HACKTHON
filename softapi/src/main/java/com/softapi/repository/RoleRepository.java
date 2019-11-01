package com.softapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.softapi.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer>{

	
	@Query(value="select * from role where name=:name",nativeQuery=true)
	Role findRoleByNameParam(@Param("name") String name);
	
	@Query(value="select * from role where id=:id",nativeQuery=true)
	Role findRoleById(@Param("id") String id);
	
	@Query(value="select role_id from usuarios_role where usuarios_id=:id",nativeQuery=true)
	Integer findRoleIdByUserId(@Param("id") String id);
}
