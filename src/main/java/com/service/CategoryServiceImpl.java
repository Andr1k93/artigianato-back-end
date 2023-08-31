package com.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.entity.Category;
import com.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository cr;

	@Override
	public ResponseEntity<List<Category>> get() {
		return new ResponseEntity<>(cr.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> delete(String id) {
		try {
			cr.deleteById(id);
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {

		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<Category> post(Category category) {
		try {
			cr.save(category);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(category, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Category> patch(Category category) {

		try {

			cr.save(category);
			return new ResponseEntity<>(category, HttpStatus.OK);
		} catch (NoSuchElementException | IllegalArgumentException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {

		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
