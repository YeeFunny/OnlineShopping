package com.repository;

import java.util.List;

import com.dto.Product;

public interface ProductRepository {

	public Product getProductById(int productId);
	
	public List<Product> getProducts(String keyword);
	
	
}
