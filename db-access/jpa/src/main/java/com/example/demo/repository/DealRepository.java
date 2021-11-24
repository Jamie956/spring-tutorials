package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Deal;

public interface DealRepository extends JpaRepository<Deal, Long> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE Deal set value =:value WHERE id =:id")
	void updateValueById(@Param("id") Long id, @Param("value") String value);
}
