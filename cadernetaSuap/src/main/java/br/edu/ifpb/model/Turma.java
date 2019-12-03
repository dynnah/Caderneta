package br.edu.ifpb.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;



@Entity
public class Turma{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Campo obrigatório")
	private String codigo;
	
	@OneToMany(mappedBy="turma", cascade= CascadeType.ALL) 
	private List<Aluno> alunos;
	
	@OneToMany(mappedBy="turma", targetEntity = Aluno.class, cascade= CascadeType.ALL) 
	private List<Nota> notas;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="aula_turma", referencedColumnName="id",nullable=false)
	private Aula aula;
	
	@ManyToOne  
	  @JoinColumn(name="codigo_disciplina", nullable=true)
	private Disciplina disciplina;
	
	public Turma(String codigo) {
		super();
		this.codigo = codigo;
	}

	protected Turma() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Turma [id=" + id + ", codigo=" + codigo + "]";
	}
	

}
