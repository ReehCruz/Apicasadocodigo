package br.com.deveficiente.apicdc.controller.form;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaForm {
	
	@NotBlank
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
