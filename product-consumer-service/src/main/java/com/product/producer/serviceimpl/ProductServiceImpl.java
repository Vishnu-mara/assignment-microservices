package com.product.producer.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.producer.feign.ProductFeignClient;
import com.product.producer.service.ProductService;
import com.product.producer.vo.ProductVo;

@Service
public class ProductServiceImpl implements ProductService{

	private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private ProductFeignClient productFeignClient;
	
	@Override
	public ProductVo getProductInfoById(String productId) {
		ProductVo productVo = productFeignClient.getProductById(productId);
		LOG.info("Product info "+productVo);
		return productVo;
	}

}
