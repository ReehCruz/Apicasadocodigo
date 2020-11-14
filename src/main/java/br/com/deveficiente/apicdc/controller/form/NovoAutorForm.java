package br.com.deveficiente.apicdc.controller.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import br.com.deveficiente.apicdc.model.Autor;

public class NovoAutorForm {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@URL
	private String linkGithub;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLinkGithub() {
		return linkGithub;
	}

	public void setLinkGithub(String linkGithub) {
		this.linkGithub = linkGithub;
	}

	public Autor novoAutor() {
		return new Autor(nome, linkGithub);
	}
	
	
}
