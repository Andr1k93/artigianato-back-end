package com.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.entity.Product;

public interface ProductService {

	public ResponseEntity<List<Product>> get();

	public ResponseEntity<String> delete(String id);

	public ResponseEntity<Product> post(Product product);

	public ResponseEntity<Product> patch(Product product);
}
