package com.fatec.antenas.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Aluno")
public class DocumentAluno extends Usuario{

	public DocumentAluno(String _id, String nome, String email, String senha, Boolean ativo) {
		super(_id, nome, email, senha, ativo, ativo);
		// TODO Auto-generated constructor stub
	}

}
