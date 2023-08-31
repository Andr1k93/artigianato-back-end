package com.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String productId;

	private String name;

	private Integer price;

	private String size;

	@ManyToMany
	@JoinColumn(name = "category_id")
	private List<Category> categories;

	private String color;

	@ManyToMany
	@JoinColumn(name = "order_id")
	private List<Ordine> orders;

	@CreationTimestamp
	private LocalDate createdAt;

	@UpdateTimestamp
	private LocalDate updatedAt;
}
