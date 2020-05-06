package com.fatec.antenas.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Reuniao")
public class Reuniao {
	private String data;
	private String local;
	private String horario;
	
	public Reuniao(String data, String local, String horario) {
		super();
		this.data = data;
		this.local = local;
		this.horario = horario;
	}
	

	
	
	
}
