package br.com.deveficiente.apicdc.controller.validator;

import java.util.Optional;

import br.com.deveficiente.apicdc.controller.form.NovoLivroForm;
import br.com.deveficiente.apicdc.model.Livro;
import br.com.deveficiente.apicdc.repository.LivroRepository;

public class IsbnUnicoValidator extends CampoUnicoLivroValidator  {

	private LivroRepository livroRepository;

	public IsbnUnicoValidator(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@Override
	public Optional<Livro> buscaLivroPorCampo(NovoLivroForm novoLivroForm) {
		return livroRepository.findByIsbn(novoLivroForm.getIsbn());
	}

	@Override
	protected String getNomeCampoInvalido() {
		return "isbn";
	}
}
