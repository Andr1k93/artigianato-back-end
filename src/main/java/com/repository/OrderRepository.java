package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Ordine;

public interface OrderRepository extends JpaRepository<Ordine, String> {

}
