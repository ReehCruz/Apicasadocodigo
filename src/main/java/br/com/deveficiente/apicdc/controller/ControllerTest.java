package br.com.deveficiente.apicdc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {

	@GetMapping(value="/api/test")
	public String test() {
		return "configurado";
	}
}

