package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Product;
import com.service.ProductService;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class ProductController {

	@Autowired
	ProductService ps;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> get() {
		return ps.get();
	}

	@PostMapping("/products")
	public ResponseEntity<Product> post(@RequestBody Product product) {
		return ps.post(product);
	}

	@PatchMapping("/products")
	public ResponseEntity<Product> patch(@RequestBody Product product) {
		return ps.patch(product);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {
		return ps.delete(id);
	}
}
