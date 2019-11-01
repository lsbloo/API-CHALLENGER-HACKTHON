package com.softapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softapi.models.Shopkeeper;

@Repository
public interface ShopKeeperRepository   extends CrudRepository<Shopkeeper,Integer>{

}
