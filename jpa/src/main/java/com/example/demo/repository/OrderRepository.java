package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	@Query(value = "SELECT o FROM Order o WHERE o.title = ?1")
	Order findByTitle(String title);
	@Query(value = "SELECT o FROM Order o WHERE o.title = ?1 AND o.status = ?2")
	Order findByTitleAndStatus(String title, String status);
}
