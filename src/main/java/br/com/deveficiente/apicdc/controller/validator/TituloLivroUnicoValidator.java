package br.com.deveficiente.apicdc.controller.validator;

import java.util.Optional;

import br.com.deveficiente.apicdc.controller.form.NovoLivroForm;
import br.com.deveficiente.apicdc.model.Livro;
import br.com.deveficiente.apicdc.repository.LivroRepository;

public class TituloLivroUnicoValidator extends CampoUnicoLivroValidator {

	private LivroRepository livroRepository;

	public TituloLivroUnicoValidator(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@Override
	public Optional<Livro> buscaLivroPorCampo(NovoLivroForm novoLivroForm) {
		return livroRepository.findByTitulo(novoLivroForm.getTitulo());
	}

	@Override
	protected String getNomeCampoInvalido() {
		return "titulo";
	}


}
