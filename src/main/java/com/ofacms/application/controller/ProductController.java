package com.ofacms.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ofacms.application.model.Product;
import com.ofacms.application.service.ProductService;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public String addProduct(@RequestParam("productName") String productName,
			@RequestParam("description") String description, @RequestParam("price") BigDecimal price,
			@RequestParam("stockQuantity") int stockQuantity, @RequestParam("categoryName") String categoryName,
			@RequestParam(value = "imageUrl", required = false) MultipartFile imageUrl) {

		try {
			byte[] imageBytes = null;
			if (imageUrl != null && !imageUrl.isEmpty()) {
				if (imageUrl.getSize() > 10 * 1024 * 1024) {
					return "File size exceeds the maximum limit of 10MB";
				}
				imageBytes = imageUrl.getBytes();
			}

			Product product = new Product();
			product.setProductName(productName);
			product.setDescription(description);
			product.setPrice(price);
			product.setStockQuantity(stockQuantity);
			product.setCategoryName(categoryName);
			product.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			product.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			product.setImageUrl(imageBytes);

			productService.addProduct(product);
			return "AddSuccess";
		} catch (IOException e) {
			e.printStackTrace();
			return "AddFailure";
		}
	}

	@GetMapping("/all")
	public List<Product> viewAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		return productService.getProductById(id);
	}

	@DeleteMapping("/{id}")
	public String deleteProductById(@PathVariable("id") int id) {
		try {
			productService.deleteProduct(id);
			return "DeleteSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return "DeleteFailure";
		}
	}

	@PutMapping("/{id}")
	public String updateProduct(@PathVariable int id, @RequestParam("productName") String productName,
			@RequestParam("description") String description, @RequestParam("price") BigDecimal price,
			@RequestParam("stockQuantity") Integer stockQuantity, @RequestParam("categoryName") String categoryName,
			@RequestParam(value = "imageUrl", required = false) MultipartFile image) {

		String msg;
		try {
			Product existingProduct = productService.getProductById(id);
			if (existingProduct == null) {
				return "Product not found";
			}

			if (image != null && !image.isEmpty()) {
				if (image.getSize() > 10 * 1024 * 1024) {
					return "File size exceeds the maximum limit of 10MB";
				}
				existingProduct.setImageUrl(image.getBytes()); // Replace the existing image with the new one
			}

			existingProduct.setProductName(productName);
			existingProduct.setDescription(description);
			existingProduct.setPrice(price);
			existingProduct.setStockQuantity(stockQuantity);
			existingProduct.setCategoryName(categoryName);
			existingProduct.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

			productService.updateProduct(existingProduct);

			msg = "UpdateSuccess";
		} catch (IOException e) {
			e.printStackTrace();
			msg = "UpdateFailure";
		}
		return msg;
	}
}
