package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	@Query(value = "SELECT r FROM Role r WHERE r.name=:name AND r.permission=:permission")
	Role getByNameAndPermission(@Param("name") String name, @Param("permission") String permission);
}
