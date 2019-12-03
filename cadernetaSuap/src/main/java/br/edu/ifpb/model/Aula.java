package br.edu.ifpb.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Id;

@Entity
public class Aula {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 100, message="Máximo de 100 caracteres")
	private String assunto;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	protected Date data;
	
	@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="codigo_turma", referencedColumnName="codigo",nullable=false)
	private Turma turma;
	
	public Aula(Long id, String assunto, Date data) {
		super();
		this.id = id;
		this.assunto = assunto;
		this.data = data;
	}

	public Aula() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Aula [id=" + id + ", assunto=" + assunto + ", data=" + data + "]";
	}
	
	
	

}
