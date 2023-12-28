package com.product.producer.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.product.producer.entity.Product;
import com.product.producer.response.ServiceResponse;

public interface ProductService {

	ResponseEntity<ServiceResponse<List<Product>>> getAllProducts();
	
	ResponseEntity<ServiceResponse<Product>> saveProduct(Product product);

	Product getProductById(String id);

	String sendMessage(String ProductId);

}
