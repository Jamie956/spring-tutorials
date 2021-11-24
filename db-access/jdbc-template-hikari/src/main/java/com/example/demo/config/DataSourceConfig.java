package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {
	@Value("${custom.datasource.driver-class-name}")
	private String driverClass;
	@Value("${custom.datasource.url}")
	private String url;
	@Value("${custom.datasource.username}")
	private String user;
	@Value("${custom.datasource.password}")
	private String password;

	@Value("${custom.datasource.hikari.connection-timeout}")
	private String hikariConnectionTimeout;
	@Value("${custom.datasource.hikari.maximum-pool-size}")
	private String hikariMaximunPoolSize;
	@Value("${custom.datasource.hikari.idle-timeout}")
	private String hikariIdleTimeout;
	@Value("${custom.datasource.hikari.pool-name}")
	private String hikariPoolName;

	@Bean(name = "hikariDataSource")
	public HikariDataSource hikariDataSource() {
		HikariDataSource dataSource = new HikariDataSource();

		dataSource.setMaximumPoolSize(Integer.parseInt(hikariMaximunPoolSize));
		dataSource.setConnectionTimeout(Integer.parseInt(hikariConnectionTimeout));
		dataSource.setIdleTimeout(Integer.parseInt(hikariIdleTimeout));
		dataSource.setPoolName(hikariPoolName);

		dataSource.setDriverClassName(driverClass);
		dataSource.setJdbcUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);

		return dataSource;
	}

	@Bean(name = "hikariJdbcTemplate")
	public JdbcTemplate hikariJdbcTemplate(@Qualifier("hikariDataSource") DataSource hikariMySQL) {
		return new JdbcTemplate(hikariMySQL);
	}

}
