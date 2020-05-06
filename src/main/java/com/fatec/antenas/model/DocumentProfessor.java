package com.fatec.antenas.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Professor")
public class DocumentProfessor extends Usuario{

	public DocumentProfessor(String nome, String email, String senha, Boolean ativo) {
		super(nome, email, senha, ativo, ativo);
		// TODO Auto-generated constructor stub
	}

}
