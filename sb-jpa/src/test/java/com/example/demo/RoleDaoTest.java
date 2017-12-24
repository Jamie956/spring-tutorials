package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleDaoTest {
	@Autowired
	private RoleRepository roleRepository;

	@Test
	public void save() {
		Role r = roleRepository.save(new Role("user", "add"));
		System.out.println("r => "+r);
	}
	
	@Test
	public void getByNameAndPermission() {
		Role r = roleRepository.getByNameAndPermission("admin", "all");
		System.out.println("r => "+r);
	}
	
}
