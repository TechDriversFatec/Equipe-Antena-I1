package com.fatec.antenas.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Projeto")
public class DocumentProjeto {
	@Id
	private String _id;
	private String chave;
	private String titulo;
	private String descricaoBreve;
	private String descricaoCompleta;
	private String descricaoTecnologica;
	private String linkExterno1;
	private String linkExterno2;
	private Integer fase;
	private List<Reuniao> reuniao;
	private Status status;
	private List<String> entregas;
	private String responsavelCadi;
	private String responsavelEmpresario;
	private List<String> responsavelProfessor;
	private List<String> alunos;
	
	

	
	public DocumentProjeto() {
		super();
	}
	
	public DocumentProjeto(String titulo, String descricaoBreve, String descricaoCompleta, String descricaoTecnologica,
			String linkExterno1, String linkExterno2, Integer fase, Status status, String responsavelEmpresario) {
		super();
		this.titulo = titulo;
		this.descricaoBreve = descricaoBreve;
		this.descricaoCompleta = descricaoCompleta;
		this.descricaoTecnologica = descricaoTecnologica;
		this.linkExterno1 = linkExterno1;
		this.linkExterno2 = linkExterno2;
		this.fase = fase;
		this.status = status;
		this.responsavelEmpresario = responsavelEmpresario;
	}	
	
	

	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
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
	public String getLinkExterno1() {
		return linkExterno1;
	}
	public void setLinkExterno1(String linkExterno1) {
		this.linkExterno1 = linkExterno1;
	}
	public String getLinkExterno2() {
		return linkExterno2;
	}
	public void setLinkExterno2(String linkExterno2) {
		this.linkExterno2 = linkExterno2;
	}
	public Integer getFase() {
		return fase;
	}
	public void setFase(Integer fase) {
		this.fase = fase;
	}
	public List<Reuniao> getReuniao() {
		return reuniao;
	}
	public void setReuniao(Reuniao reuniao) {
		this.reuniao.add(reuniao);
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public List<String> getEntregas() {
		return entregas;
	}
	public void setEntregas(String entregas) {
		this.entregas.add(entregas);
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
	public void setResponsavelProfessor(String responsavelProfessor) {
		this.responsavelProfessor.add(responsavelProfessor);
	}
	public List<String> getAlunos() {
		return alunos;
	}
	public void setAlunos(String alunos) {
		this.alunos.add(alunos);
	}
	
	
	
	
	
}
