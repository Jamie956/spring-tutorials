package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Deal;
import com.example.demo.repository.DealRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DealDaoTest {
	@Autowired
	private DealRepository dealRepository;

	@Test
	public void save() {
		Deal d = dealRepository.save(new Deal("bingo", "yes"));
		System.out.println("d => " + d);
	}

	@Test
	public void update() {
		dealRepository.updateValueById(1L, "oops");
	}
}
