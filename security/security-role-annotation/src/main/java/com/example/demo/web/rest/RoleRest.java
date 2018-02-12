package com.example.demo.web.rest;

import java.util.*;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleRest {
	@GetMapping("/admin")
	public boolean becomeAdmin() {
		Authentication currentAuth = SecurityContextHolder.getContext().getAuthentication();
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(currentAuth.getAuthorities());
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		Authentication newAuth = new UsernamePasswordAuthenticationToken(currentAuth.getPrincipal(), currentAuth.getCredentials(), grantedAuthorities);
		SecurityContextHolder.getContext().setAuthentication(newAuth);
		return true;
	}
	
	@GetMapping("/user")
	public boolean becomeUser() {
		Authentication currentAuth = SecurityContextHolder.getContext().getAuthentication();
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(currentAuth.getAuthorities());
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		Authentication newAuth = new UsernamePasswordAuthenticationToken(currentAuth.getPrincipal(), currentAuth.getCredentials(), grantedAuthorities);
		SecurityContextHolder.getContext().setAuthentication(newAuth);
		return true;
	}
}
