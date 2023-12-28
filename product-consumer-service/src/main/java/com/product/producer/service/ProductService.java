package com.product.producer.service;

import com.product.producer.vo.ProductVo;

public interface ProductService {
	ProductVo getProductInfoById(String productId);
}
