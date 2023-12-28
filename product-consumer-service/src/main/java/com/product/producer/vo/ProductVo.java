package com.product.producer.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVo{

	private String id;
	
	private String name;
	
	private Double cost;
	
	private Integer quantity;

}
