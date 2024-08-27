package com.ofacms.application.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofacms.application.model.Product;
import com.ofacms.application.repository.ProductRepository;
import com.ofacms.application.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(int id) {
		return productRepository.findById(id);
	}

	@Override
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.update(product);
	}

}
