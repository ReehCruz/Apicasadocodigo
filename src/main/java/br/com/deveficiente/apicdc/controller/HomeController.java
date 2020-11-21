package br.com.deveficiente.apicdc.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.deveficiente.apicdc.controller.dto.LivroParaHomeDTO;
import br.com.deveficiente.apicdc.repository.LivroRepository;

@RestController
public class HomeController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping(value = "/api/home")
	public Collection<LivroParaHomeDTO> lista(){
		return livroRepository.findAll().stream()
				.map(LivroParaHomeDTO::new)
				.collect(Collectors.toList()); 
	}
}
