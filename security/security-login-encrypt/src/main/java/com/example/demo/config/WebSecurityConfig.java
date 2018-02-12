package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private SecurityUserDetailsService securityUserDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http
			.authorizeRequests()
				.antMatchers("/","/register/**").permitAll()
				.antMatchers("/rest/user/**").hasRole("USER")
				.antMatchers("/rest/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login").permitAll().defaultSuccessUrl("/login_success")
				.and()
			.logout().logoutUrl("/logout").permitAll().logoutSuccessUrl("/logout_success");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(securityUserDetailsService);
		
        builder.userDetailsService(securityUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}