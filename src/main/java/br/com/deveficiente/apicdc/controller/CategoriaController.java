package br.com.deveficiente.apicdc.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.deveficiente.apicdc.controller.form.NovaCategoriaForm;
import br.com.deveficiente.apicdc.controller.validator.SemCategoriaComNomeDuplicadoValidator;
import br.com.deveficiente.apicdc.model.Categoria;
import br.com.deveficiente.apicdc.repository.CategoriaRepository;

@RestController
public class CategoriaController {
	
	@Autowired
	public CategoriaRepository categoriaRepository;
	
	@InitBinder("novaCategoriaForm")
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new SemCategoriaComNomeDuplicadoValidator(categoriaRepository)); 
	}
	
	@PostMapping(value = "api/categoria")
	@Transactional
	public void nova(@Valid @RequestBody NovaCategoriaForm form) {
		Categoria novaCategoria = new Categoria(form.getNome());
		categoriaRepository.save(novaCategoria);
	
	   }
	}
