package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	Item awesomeFindByName(String name);
	Item awesomeFindByNameAndPrice(String name, int price);
}
