package br.edu.ifpb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.model.Professor;

public interface IProfessorRepository extends JpaRepository<Professor, Long> {

}
