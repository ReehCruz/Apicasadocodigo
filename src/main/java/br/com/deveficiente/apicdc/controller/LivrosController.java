package br.com.deveficiente.apicdc.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.deveficiente.apicdc.controller.form.NovoLivroForm;
import br.com.deveficiente.apicdc.controller.validator.IsbnUnicoValidator;
import br.com.deveficiente.apicdc.controller.validator.TituloLivroUnicoValidator;
import br.com.deveficiente.apicdc.model.Livro;
import br.com.deveficiente.apicdc.repository.AutorRepository;
import br.com.deveficiente.apicdc.repository.LivroRepository;

@RestController
public class LivrosController {
	
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private Uploader uploader;
	@Autowired
	private LivroRepository livroRepository;
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(new IsbnUnicoValidator(livroRepository),new TituloLivroUnicoValidator(livroRepository));
	}

	@PostMapping(value = "/api/livro")
	@Transactional
	public void novo(@Valid NovoLivroForm form) {		
		Livro livro = form.novoLivro(autorRepository,uploader);
		livroRepository.save(livro);
	}
}
