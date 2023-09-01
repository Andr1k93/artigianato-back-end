package com.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.LoginMessage;
import com.dto.LoginDTO;
import com.dto.UserDTO;
import com.entity.User;

public interface UserService {

	ResponseEntity<String> addUser(UserDTO employeeDTO);

	LoginMessage loginUser(LoginDTO loginDTO);

	List<User> findAll();

	public void delete(Integer id);

	User findByEmail(String email);

}