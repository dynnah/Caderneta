package br.edu.ifpb.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Aluno extends Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Campo obrigatório")
	@Size(max = 150)
	private String nome;
	
	@NotBlank
	@Size(max = 16, message="Máximo de 16 caracteres")
	private Long matricula;
	
	@ManyToOne
	private Turma turma;
	
	public Aluno(String nome, Long matricula) {
		super();
		this.nome = nome;
		this.matricula = matricula;
	}

	public Aluno() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", matricula=" + matricula + ", login=" + "]";
	}
	
	

}
