package com.example;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByName(String name, Pageable pageable);

	@Query(value = "SELECT * FROM t_user WHERE id = ?1", nativeQuery = true)
	User nativeQueryById(int id);

	@Query(value = "SELECT u FROM User u WHERE u.id=:myId")
	User paramQueryById(@Param("myId") long myId);

	@Query(value = "SELECT u FROM User u WHERE u.id = ?1")
	User notNativeQueryById(long myId);

	User nameNativeQueryById(int myId);
}
