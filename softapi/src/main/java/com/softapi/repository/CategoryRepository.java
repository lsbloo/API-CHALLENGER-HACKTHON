package com.softapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.softapi.models.Category;


@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer>{

	
	@Query(value="select * from category where codigo=:tag",nativeQuery=true)
	Category getCategoryByTag(@Param("tag") String tag);
	
}
