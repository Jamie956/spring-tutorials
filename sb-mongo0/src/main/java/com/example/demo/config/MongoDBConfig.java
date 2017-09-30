package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.document.Product;
import com.example.demo.repository.ProductRepository;

@EnableMongoRepositories(basePackageClasses = ProductRepository.class)
@Configuration
public class MongoDBConfig {

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return strings -> {
			productRepository.save(new Product(01, "product01", "1.00"));
			productRepository.save(new Product(02, "product02", "2.00"));
			productRepository.save(new Product(03, "product03", "3.00"));
		};
	}

}
