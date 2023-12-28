package com.product.producer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.product.producer.vo.ProductVo;

@FeignClient(value = "product-producer-service", url = "http://localhost:8763")
public interface ProductFeignClient {

	@GetMapping(value = "/product/{id}")
	ProductVo getProductById(@PathVariable("id") String productId);
}
