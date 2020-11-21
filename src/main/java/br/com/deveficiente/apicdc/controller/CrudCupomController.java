package br.com.deveficiente.apicdc.controller;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.deveficiente.apicdc.controller.form.NovoCupomForm;
import br.com.deveficiente.apicdc.model.Cupom;

@RestController
public class CrudCupomController {
	
	@Autowired
	private EntityManager manager;

	@PostMapping(value = "/api/cupom")
	@Transactional
	public String cria(@RequestBody @Valid NovoCupomForm form) {
		
		Cupom cupom = form.novoCupom();
		manager.persist(cupom);
		
		return "criado";
	}

}