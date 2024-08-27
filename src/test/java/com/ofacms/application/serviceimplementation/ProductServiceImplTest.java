package com.ofacms.application.serviceimplementation;

import com.ofacms.application.model.Product;
import com.ofacms.application.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

 class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProducts() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Product product1 = new Product(1, "Product1", "Description1", BigDecimal.valueOf(100.0), 10, "Category1", now, now, new byte[]{});
        Product product2 = new Product(2, "Product2", "Description2", BigDecimal.valueOf(150.0), 5, "Category2", now, now, new byte[]{});
        List<Product> products = Arrays.asList(product1, product2);

        when(productRepository.findAll()).thenReturn(products);

        List<Product> result = productService.getAllProducts();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Product1", result.get(0).getProductName());
        assertEquals("Product2", result.get(1).getProductName());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testGetProductById() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Product product = new Product(1, "Product1", "Description1", BigDecimal.valueOf(100.0), 10, "Category1", now, now, new byte[]{});

        when(productRepository.findById(anyInt())).thenReturn(product);

        Product result = productService.getProductById(1);

        assertNotNull(result);
        assertEquals(1, result.getProductId());
        assertEquals("Product1", result.getProductName());
        verify(productRepository, times(1)).findById(1);
    }

    @Test
    void testDeleteProduct() {
        doNothing().when(productRepository).deleteById(anyInt());

        productService.deleteProduct(1);

        verify(productRepository, times(1)).deleteById(1);
    }

    @Test
    void testUpdateProduct() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Product product = new Product(1, "Product1", "Description1", BigDecimal.valueOf(100.0), 10, "Category1", now, now, new byte[]{});

        doNothing().when(productRepository).update(any(Product.class));

        productService.updateProduct(product);

        verify(productRepository, times(1)).update(product);
    }
}
