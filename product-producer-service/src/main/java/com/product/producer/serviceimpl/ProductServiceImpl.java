package com.product.producer.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.producer.config.MessageProducer;
import com.product.producer.entity.Product;
import com.product.producer.repo.ProductRepo;
import com.product.producer.response.ServiceResponse;
import com.product.producer.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	private final MessageProducer messageProducer;

	@Autowired
	public ProductServiceImpl(MessageProducer messageProducer) {
		this.messageProducer = messageProducer;
	}

	@Override
	public ResponseEntity<ServiceResponse<List<Product>>> getAllProducts() {
		return new ResponseEntity<>(new ServiceResponse<>(HttpStatus.OK.value(), "Success", productRepo.findAll()), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ServiceResponse<Product>> saveProduct(Product request) {
		Optional<Product> productInfo = productRepo.findByName(request.getName());
		if (productInfo.isPresent()) {
			return new ResponseEntity<>(new ServiceResponse<>(HttpStatus.OK.value(), "Duplicate product",productInfo.get()), HttpStatus.OK);
		}
		Product product = request;
		product.setId(UUID.randomUUID().toString());
		request = productRepo.save(request);
		return new ResponseEntity<>(new ServiceResponse<>(HttpStatus.OK.value(), "Success",request), HttpStatus.OK);
	}

	@Override
	public Product getProductById(String id) {
		Optional<Product> productInfo = productRepo.findById(id);
		if (productInfo.isPresent()) {
			return productInfo.get();
		}
		return null;
	}

	@Override
	public String sendMessage(String productId) {
		messageProducer.sendMessage(productId);
		return "Message sent: " + productId;
	}

}
