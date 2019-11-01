package com.softapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softapi.repository.ProductRepository;


@Service
public class ProductService {

	
	
	private final ProductRepository productRepository;
	
	
	
	@Autowired
	private ProductService(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}
	
	
	// GEtter;
	
}
