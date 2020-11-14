package br.com.deveficiente.apicdc.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.deveficiente.apicdc.model.Livro;

public interface LivroRepository extends CrudRepository<Livro, Long>{
	
	Optional<Livro> findByIsbn(String isbn);

	Optional<Livro> findByTitulo(String titulo);
	
	@Override
	Collection<Livro> findAll();

}
