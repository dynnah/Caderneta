package br.edu.ifpb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.model.Aluno;

public interface IAlunoRepository extends JpaRepository<Aluno, Long>{

}
