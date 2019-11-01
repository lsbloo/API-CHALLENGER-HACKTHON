package com.softapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.softapi.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer>{
	
	
	@Query(value="insert into shops_products (shop_id,product_id) values (:shop_id,:product_id)",nativeQuery=true)
	@Modifying
	@Transactional
	void insertRelationShopProduct(@Param("shop_id") Integer shop_id,@Param("product_id") Integer product_id);
	
	@Query(value="select distinct product_id from category_products where category_id=:category_id",nativeQuery=true)
	List<Integer> getProduct_id_related(@Param("category_id") Integer category_id);
	
	
	@Query(value="select * from product where id=:id",nativeQuery=true)
	Product getProductId(@Param("id") Integer id);
	
	@Modifying
	@Transactional
	@Query(value="insert into product (codigo,nome,preco,quantity) values (:codigo,:nome,:preco,:quantity)",nativeQuery=true)
	Product insertProduct(@Param("codigo") String codigo, @Param("nome") String nome, @Param("preco") String preco,
			@Param("quantity") Integer quantity);
	

	

}
