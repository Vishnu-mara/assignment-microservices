package com.product.producer.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.producer.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, String>{

	Optional<Product> findByName(String name);

}
