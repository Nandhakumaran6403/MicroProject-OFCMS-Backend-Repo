package com.ofacms.application.service;

import java.util.List;

import com.ofacms.application.model.Product;

public interface ProductService {
	void addProduct(Product product);

	List<Product> getAllProducts();

	Product getProductById(int id);

	void deleteProduct(int id);

	void updateProduct(Product product);
}
