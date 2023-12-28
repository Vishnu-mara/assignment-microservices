package com.product.producer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.producer.entity.Product;
import com.product.producer.response.ServiceResponse;
import com.product.producer.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/send-product-id")
    public String sendMessage(@RequestParam(name ="id") String productId) {
        return productService.sendMessage(productId);
    }
	
	@GetMapping("/display/all")
	public ResponseEntity<ServiceResponse<List<Product>>> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@PostMapping("/add")
	public ResponseEntity<ServiceResponse<Product>> saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") String id) {
		return productService.getProductById(id);
	}
}
