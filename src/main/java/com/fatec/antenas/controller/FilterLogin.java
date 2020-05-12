package com.fatec.antenas.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;


public class FilterLogin implements Filter {
	
		@Override
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			System.out.println("chamou");
	        HttpServletResponse httpResponse = (HttpServletResponse)response;
	        HttpServletRequest httpRequest = (HttpServletRequest)request;
	
	       
	        if (!httpRequest.getServletPath().startsWith("/empresa/painel")) {
	            // requisição para recurso estático
	            chain.doFilter(request, response);
	            return;
	        }

	     
	        Cookie token = WebUtils.getCookie(httpRequest, "token");
	        if (token == null) {
	            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
	            return;
	        }
	
	        try {
	
	            String jwt = token.getValue();
	
	            DecodedJWT decodedJwt = JWT.require(Algorithm.HMAC256("Emp@2020"))
	                    .build()
	                    .verify(jwt);
	
	            String emailUsuarioLogado = decodedJwt.getClaim("emailUsuarioLogado").toString();
	            httpRequest.setAttribute("emailUsuarioLogado", emailUsuarioLogado);
	            
	
	            // chamada autenticada
	            chain.doFilter(request, response);
	
	        } catch (JWTVerificationException ex) {
	            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
	            return;
	        }
	    }
	
	    @Override
	    public void init(FilterConfig filterConfig) {
	    }
	
	    @Override
	    public void destroy() {
	    }
}
