package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {

	@Id
	@Column(name = "user_id", length = 45)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	@Column(name = "user_name", length = 255)
	private String username;
	private String role;
	@Column(name = "email", length = 255, unique = true)
	private String email;
	@Column(name = "password", length = 255)
	private String password;

	public User() {
	}

	public User(int userid, String username, String email, String password) {
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.password = password;
	}

}
