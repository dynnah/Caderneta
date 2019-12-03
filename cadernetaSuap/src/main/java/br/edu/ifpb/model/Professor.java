			package br.edu.ifpb.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Professor extends Usuario{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 150)
	private String nome;
	
	@NotBlank(message="E-mail é obrigatório")
	@Email(message="E-mail inválido")
	private String email;
	
	@ManyToMany
	@JoinTable(name="turmas_professor", joinColumns=
		{@JoinColumn(name="turma_id")}, inverseJoinColumns=
    		{@JoinColumn(name="professor_id")})
	private List<Turma> turmas;

	public Professor(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}

	protected Professor() {
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}
}
