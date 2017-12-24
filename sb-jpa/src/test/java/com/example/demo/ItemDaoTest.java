package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemDaoTest {
	@Autowired
	private ItemRepository itemRepository;

	@Test
	public void save() {
		Item i = itemRepository.save(new Item("paper", 888, "This is cool!"));
		System.out.println("i => "+i);
	}

	@Test
	public void findByName() {
		Item i = itemRepository.awesomeFindByName("beer");
		System.out.println("i => "+i);
	}
	
	@Test
	public void findByNameAndPrice() {
		Item i = itemRepository.awesomeFindByNameAndPrice("paper", 888);
		System.out.println("i => "+i);
	}
	
}
