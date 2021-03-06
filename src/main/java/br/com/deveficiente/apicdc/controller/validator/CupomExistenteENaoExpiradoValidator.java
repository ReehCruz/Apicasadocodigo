package br.com.deveficiente.apicdc.controller.validator;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.deveficiente.apicdc.controller.form.DadosCompradorForm;
import br.com.deveficiente.apicdc.model.Cupom;
import br.com.deveficiente.apicdc.repository.CupomRepository;



public class CupomExistenteENaoExpiradoValidator implements Validator {
	
	private CupomRepository cupomRepository;
	
	public CupomExistenteENaoExpiradoValidator(CupomRepository cupomRepository) {
		this.cupomRepository = cupomRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return DadosCompradorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		DadosCompradorForm form = (DadosCompradorForm) target;
		
		Optional<Cupom> possivelCupom = cupomRepository.findByCodigo(form.getCodigoCupom());
		
		if(!possivelCupom.isPresent()) {
			errors.rejectValue("codigoCupom",null,"Este código não existe");
			return;
		}
		
		Cupom cupom = possivelCupom.get();		
		if(!cupom.taValido()) {
			errors.rejectValue("codigoCupom",null,"Infelizmente este cupom expirou");
		}
		
		
		
	}

}