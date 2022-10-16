package com.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class SpringDataSourceConfig {
	@Bean(name = "hikariDataSource")
	public HikariDataSource hikariDataSource() {
		HikariDataSource dataSource = new HikariDataSource();

		dataSource.setMaximumPoolSize(5);
		dataSource.setConnectionTimeout(1000);
		dataSource.setIdleTimeout(5000);
		dataSource.setPoolName("MyHikariPool");

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=utf-8");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		return dataSource;
	}

	@Bean(name = "hikariJdbcTemplate")
	public JdbcTemplate hikariJdbcTemplate(@Qualifier("hikariDataSource") DataSource hikariMySQL) {
		return new JdbcTemplate(hikariMySQL);
	}

}
