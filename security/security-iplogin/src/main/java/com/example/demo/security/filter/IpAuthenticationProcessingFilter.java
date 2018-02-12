package com.example.demo.security.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.security.IpAuthenticationToken;

public class IpAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {
	// Set ip verify path
    public IpAuthenticationProcessingFilter() {
        super(new AntPathRequestMatcher("/ipVerify"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        // Get host info
        String host = request.getRemoteHost();
        //Set ip in IpAuthenticationToken that extends AbstractAuthenticationToken
        return getAuthenticationManager().authenticate(new IpAuthenticationToken(host));
    }
}