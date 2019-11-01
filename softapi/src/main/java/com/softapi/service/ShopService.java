package com.softapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softapi.dto.ProductDTO;
import com.softapi.models.Category;
import com.softapi.models.Product;
import com.softapi.models.Shop;
import com.softapi.repository.CategoryRepository;
import com.softapi.repository.EnderecoRepository;
import com.softapi.repository.ProductRepository;
import com.softapi.repository.ShopRepository;

@Service
public class ShopService {
	
	
	
	private final ShopRepository shopRepository;
	private final EnderecoRepository enderecoRepository;
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	
	@Autowired
	public ShopService(ShopRepository shopRepository,EnderecoRepository enderecoRepository
			, ProductRepository productRepository,CategoryRepository categoryRepository) {
		this.shopRepository=shopRepository;
		this.enderecoRepository=enderecoRepository;
		this.productRepository=productRepository;
		this.categoryRepository=categoryRepository;
	}
	
	public ProductDTO getShopping(String tags) {
		String[] split = tags.split(",");
		List<String> list_tags =new ArrayList<String>();
		for(int i = 0 ; i<split.length ; i ++) {
			list_tags.add(split[i]);
		}
		
		return null;
	}
	public void saveCategories(List<Category> list_category) {
		for(Category x : list_category) {
			this.categoryRepository.save(x);
		}
	}
	public Shop save(Shop shop) {
		boolean pass=false;
		List<Product> products = shop.getProducts();
		this.enderecoRepository.save(shop.getEndereco());
		List<Product> product_valid = new ArrayList<>();
		for(Product k : products) {
			try {
			if(k.getCategory().size() != 0 || k.getCategory() != null) {
				
				saveCategories(k.getCategory());
				
				product_valid.add(this.productRepository.save(k));
			}
		}catch(NullPointerException e) {
			pass=true;
		}
		Shop shop_id = this.shopRepository.save(shop);
		for(int i = 0 ; i < product_valid.size() ; i ++) {
			this.productRepository.insertRelationShopProduct(shop_id.getId(), product_valid.get(i).getId());
		}
		
		return shop_id;
	}
	return null;
	}
		
}
