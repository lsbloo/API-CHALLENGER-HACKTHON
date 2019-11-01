package com.softapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.softapi.models.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco,Integer>{
	

}
