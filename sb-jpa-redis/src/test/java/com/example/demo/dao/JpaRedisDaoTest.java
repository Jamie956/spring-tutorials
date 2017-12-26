package com.example.demo.dao;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaRedisDaoTest {

	@Autowired
	private BookRepository bookRepository;
	
  @Autowired
  private RedisTemplate<Long, Book> redisTemplate;
	
	@Test
	public void save() {
		Book b = bookRepository.save(new Book("readme",99));
		System.out.println(b);
	}

	@Test
	public void find() {
		Long key = 1L;
		ValueOperations<Long, Book> operations = redisTemplate.opsForValue();
		boolean hasKey = redisTemplate.hasKey(key);
		System.out.println(hasKey);
		if (hasKey) {
			Book b = operations.get(key);
			System.out.println("from redis => " + b);
		} else {
			Book b = bookRepository.findOne(1L);
			System.out.println("from mysql => " + b);
			operations.set(key, b, 60, TimeUnit.SECONDS);
		}
	}
	
	@Test
	public void update() {
		Book b = bookRepository.findOne(1L);
		b.setPrice(100);
		bookRepository.save(b);

		Long key = b.getId();
		boolean hasKey = redisTemplate.hasKey(key);
		if(hasKey){
			redisTemplate.delete(key);
		}
	}
	
	@Test
	public void remove() {
		Long key = 1L;
		bookRepository.delete(key);
		boolean hasKey = redisTemplate.hasKey(key);
		if(hasKey){
			redisTemplate.delete(key);
		}
	}
}