package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {
	// PRIMARY
	@Value("${custom.datasource.primary.driver-class-name}")
	private String primaryDriverClass;
	@Value("${custom.datasource.primary.url}")
	private String primaryUrl;
	@Value("${custom.datasource.primary.username}")
	private String primaryUser;
	@Value("${custom.datasource.primary.password}")
	private String primaryPassword;

	// SECONDARY
	@Value("${custom.datasource.secondary.driver-class-name}")
	private String secondaryDriverClass;
	@Value("${custom.datasource.secondary.url}")
	private String secondaryUrl;
	@Value("${custom.datasource.secondary.username}")
	private String secondaryUser;
	@Value("${custom.datasource.secondary.password}")
	private String secondaryPassword;

	@Bean(name = "primaryDataSource")
	@Primary
	public DriverManagerDataSource primaryDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(primaryDriverClass);
		dataSource.setUrl(primaryUrl);
		dataSource.setUsername(primaryUser);
		dataSource.setPassword(primaryPassword);
		return dataSource;
	}
	@Bean(name = "primaryJdbcTemplate")
	@Primary
	public JdbcTemplate masterJdbcTemplate(@Qualifier("primaryDataSource") DataSource dsMySQL) {
		return new JdbcTemplate(dsMySQL);
	}

	@Bean(name = "secondaryDataSource")
	public DriverManagerDataSource secondaryDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(secondaryDriverClass);
		dataSource.setUrl(secondaryUrl);
		dataSource.setUsername(secondaryUser);
		dataSource.setPassword(secondaryPassword);
		return dataSource;
	}
	@Bean(name = "secondaryJdbcTemplate")
	public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource dsMySQL) {
		return new JdbcTemplate(dsMySQL);
	}
	
}
