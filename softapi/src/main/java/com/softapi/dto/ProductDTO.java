package com.softapi.dto;

import java.util.List;

import com.softapi.models.Product;
import com.softapi.models.Shop;

public class ProductDTO {

	
	private List<Product> list_products;
	
	private List<Shop> list_shopping;

	public List<Product> getList_products() {
		return list_products;
	}

	public void setList_products(List<Product> list_products) {
		this.list_products = list_products;
	}

	public List<Shop> getList_shopping() {
		return list_shopping;
	}

	public void setList_shopping(List<Shop> list_shopping) {
		this.list_shopping = list_shopping;
	}
	
	
}
