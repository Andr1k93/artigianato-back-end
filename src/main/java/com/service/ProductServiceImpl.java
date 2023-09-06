package com.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dto.ProductDTO;
import com.entity.Category;
import com.entity.Product;
import com.repository.CategoryRepository;
import com.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository pr;

	@Autowired
	private CategoryRepository cr;

	@Override
	public ResponseEntity<List<Product>> get() {
		return new ResponseEntity<>(pr.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> delete(String id) {
		try {
			pr.deleteById(id);
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {

		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<Product> patch(Product product) {

		try {
			pr.save(product);
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch (NoSuchElementException | IllegalArgumentException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {

		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<Product> post(ProductDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());

		// Find the Category by ID and associate it with the Product
		Category category = cr.findById(productDTO.getCategoryId()).orElseThrow(
				() -> new EntityNotFoundException("Category not found with ID: " + productDTO.getCategoryId()));

		// Add the Product to the Category and vice versa
		product.getCategories().add(category);
		category.getProducts().add(product);

		// Save the Product entity (this will also cascade the Category association)
		pr.save(product);
		return new ResponseEntity<>(product, HttpStatus.OK);

	}

}
