package com.fatec.antenas.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Projeto")
public class DocumentProjeto {
	@Id
	private String id;
	private String chave;
	private String titulo;
	private String descricaoBreve;
	private String descricaoCompleta;
	private String descricaoTecnologica;
	private Integer fase;
	private Reuniao reuniao;
	private String statusMotivo;
	private String status;
	private Entregas entregas;
	private String responsavelCadi;
	private String responsavelEmpresario;
	private List<String> responsavelProfessor;
	private List<String> alunos;
	
	public DocumentProjeto(String id, String chave, String titulo, String descricaoBreve, String descricaoCompleta,
			String descricaoTecnologica, Integer fase, Reuniao reuniao, String statusMotivo, String status,
			Entregas entregas, String responsavelCadi, String responsavelEmpresario, List<String> responsavelProfessor,
			List<String> alunos) {
		super();
		this.id = id;
		this.chave = chave;
		this.titulo = titulo;
		this.descricaoBreve = descricaoBreve;
		this.descricaoCompleta = descricaoCompleta;
		this.descricaoTecnologica = descricaoTecnologica;
		this.fase = fase;
		this.reuniao = reuniao;
		this.statusMotivo = statusMotivo;
		this.status = status;
		this.entregas = entregas;
		this.responsavelCadi = responsavelCadi;
		this.responsavelEmpresario = responsavelEmpresario;
		this.responsavelProfessor = responsavelProfessor;
		this.alunos = alunos;
	}
	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricaoBreve() {
		return descricaoBreve;
	}

	public void setDescricaoBreve(String descricaoBreve) {
		this.descricaoBreve = descricaoBreve;
	}

	public String getDescricaoCompleta() {
		return descricaoCompleta;
	}

	public void setDescricaoCompleta(String descricaoCompleta) {
		this.descricaoCompleta = descricaoCompleta;
	}

	public String getDescricaoTecnologica() {
		return descricaoTecnologica;
	}

	public void setDescricaoTecnologica(String descricaoTecnologica) {
		this.descricaoTecnologica = descricaoTecnologica;
	}

	public Integer getFase() {
		return fase;
	}

	public void setFase(Integer fase) {
		this.fase = fase;
	}

	public Reuniao getReuniao() {
		return reuniao;
	}

	public void setReuniao(Reuniao reuniao) {
		this.reuniao = reuniao;
	}

	public String getStatusMotivo() {
		return statusMotivo;
	}

	public void setStatusMotivo(String statusMotivo) {
		this.statusMotivo = statusMotivo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Entregas getEntregas() {
		return entregas;
	}

	public void setEntregas(Entregas entregas) {
		this.entregas = entregas;
	}

	public String getResponsavelCadi() {
		return responsavelCadi;
	}

	public void setResponsavelCadi(String responsavelCadi) {
		this.responsavelCadi = responsavelCadi;
	}

	public String getResponsavelEmpresario() {
		return responsavelEmpresario;
	}

	public void setResponsavelEmpresario(String responsavelEmpresario) {
		this.responsavelEmpresario = responsavelEmpresario;
	}

	public List<String> getResponsavelProfessor() {
		return responsavelProfessor;
	}

	public void setResponsavelProfessor(List<String> responsavelProfessor) {
		this.responsavelProfessor = responsavelProfessor;
	}

	public List<String> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<String> alunos) {
		this.alunos = alunos;
	}
	
	
	
}
