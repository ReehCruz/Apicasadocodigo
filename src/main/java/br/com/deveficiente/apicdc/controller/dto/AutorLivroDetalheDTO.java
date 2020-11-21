package br.com.deveficiente.apicdc.controller.dto;

import br.com.deveficiente.apicdc.model.Autor;

public class AutorLivroDetalheDTO {
	
	private String nome;
	private String descricao;

	public AutorLivroDetalheDTO(Autor autor) {
		nome = autor.getNome();
		descricao = "Aqui precisa vir a descricao do autor";
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
