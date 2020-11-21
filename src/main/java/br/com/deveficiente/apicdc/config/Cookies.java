package br.com.deveficiente.apicdc.config;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.deveficiente.apicdc.model.Carrinho;

@Component
public class Cookies {
	
	public void writeAsJson(String key,Carrinho carrinho, HttpServletResponse response) {		
		try {
			Cookie cookie = new Cookie(key, new ObjectMapper().writeValueAsString(carrinho));
			cookie.setHttpOnly(true);
			cookie.setPath("/");
			response.addCookie(cookie);		
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

}
