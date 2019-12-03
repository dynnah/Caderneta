package br.edu.ifpb.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import javax.persistence.Id;

@Entity
public class Nota {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Campo obrigatório")
	private int[] notas;
	
	@NotBlank(message="Campo obrigatório")
	private int numNotas;
	
	@ManyToOne  
	  @JoinColumn(name="codigo_turma", referencedColumnName="codigo",nullable=false)
	private Turma turma;
	
	public Nota(int[] notas, int numNotas) {
		super();
		this.notas = notas;
		this.numNotas = numNotas;
	}

	protected Nota() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int[] getNotas() {
		return notas;
	}

	public void setNotas(int[] notas) {
		this.notas = notas;
	}

	public int getNumNotas() {
		return numNotas;
	}

	public void setNumNotas(int numNotas) {
		this.numNotas = numNotas;
	}

	@Override
	public String toString() {
		return "Nota [id=" + id + ", notas=" + Arrays.toString(notas) + ", numNotas=" + numNotas + "]";
	}

	
}
