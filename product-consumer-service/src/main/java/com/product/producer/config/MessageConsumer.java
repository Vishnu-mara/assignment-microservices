package com.product.producer.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.producer.service.ProductService;

@Component
public class MessageConsumer {
	
	private static final Logger LOG = LoggerFactory.getLogger(MessageConsumer.class); 
	
	@Autowired
	private ProductService productService;
	
    @RabbitListener(queues = "product-info-queue")
    public void handleMessage(String message) {
        LOG.info("Received message: " + message);
        
        productService.getProductInfoById(message);
        
    }
}
