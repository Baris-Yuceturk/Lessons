package com.fibabootcamplesson01.spring.service;

import java.util.List;

import com.fibabootcamplesson01.spring.Product;

public interface ProductService {

	Product find(long productId);
	
	List<Product> findAll();
	
	void createProduct(Product product);

	void updateProduct(Product product);
	
	void deleteProduct(long productId);
}
