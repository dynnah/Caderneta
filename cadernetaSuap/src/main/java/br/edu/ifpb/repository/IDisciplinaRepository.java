package br.edu.ifpb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.model.Disciplina;

public interface IDisciplinaRepository extends JpaRepository<Disciplina, Long> {
	
	Optional<Disciplina> findByCodigo(String codigo);

}
