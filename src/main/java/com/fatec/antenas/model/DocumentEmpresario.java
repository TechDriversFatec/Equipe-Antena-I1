package com.fatec.antenas.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Empresario")
public class DocumentEmpresario extends Usuario {
	
	@NotEmpty(message = "Company name is mandatory")
	private String empresa;
	@NotEmpty(message = "CPF is mandatory")
	private String cpf;
	
	private String telefone;

	public DocumentEmpresario( String nome, String email, String senha, Boolean ativo, String empresa, String cpf,
			String telefone) {
		super(nome, email, senha, ativo, ativo);
		this.empresa = empresa;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
	
}	
