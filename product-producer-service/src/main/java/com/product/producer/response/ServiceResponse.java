package com.product.producer.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse<T> {
	private int status;
	private String message;
	private T data;

}
