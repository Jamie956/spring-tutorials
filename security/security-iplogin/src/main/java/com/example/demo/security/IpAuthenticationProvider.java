package com.example.demo.security;

import java.util.*;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class IpAuthenticationProvider implements AuthenticationProvider {
	final static Map<String, SimpleGrantedAuthority> ipAuthorityMap = new HashMap<String, SimpleGrantedAuthority>();
	static {
		ipAuthorityMap.put("127.0.0.1", new SimpleGrantedAuthority("ADMIN"));
		ipAuthorityMap.put("10.236.69.103", new SimpleGrantedAuthority("ADMIN"));
		ipAuthorityMap.put("10.236.69.104", new SimpleGrantedAuthority("FRIEND"));
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		IpAuthenticationToken ipAuthenticationToken = (IpAuthenticationToken) authentication;
		String ip = ipAuthenticationToken.getIp();
		SimpleGrantedAuthority simpleGrantedAuthority = ipAuthorityMap.get(ip);
		// If ip not exist in ipAuthorityMap
		if (simpleGrantedAuthority == null) {
			return null;
		} else {
			// Auth success, encapsulate auth info
			return new IpAuthenticationToken(ip, Arrays.asList(simpleGrantedAuthority));
		}
	}

	// Only support identity of IpAuthenticationToken
	@Override
	public boolean supports(Class<?> authentication) {
		return (IpAuthenticationToken.class.isAssignableFrom(authentication));
	}
}