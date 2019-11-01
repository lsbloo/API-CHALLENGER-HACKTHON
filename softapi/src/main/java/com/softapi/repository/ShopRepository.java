package com.softapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.softapi.models.Shop;


@Repository
public interface ShopRepository extends CrudRepository<Shop,Integer>{

	
	@Query(value="select distinct shop_id from shops_products where product_id=:id",nativeQuery=true)
	Integer getShopId(@Param("id") Integer product_id);
	
	@Query(value="select distinct * from shop where id=:id ",nativeQuery=true)
	Shop getShopById(@Param("id") Integer id);
	
	@Query(value="select distinct *  from shop where cnpj=:cnpj",nativeQuery=true)
	Shop getShopByCnpj(@Param("cnpj") String cnpj);
}
