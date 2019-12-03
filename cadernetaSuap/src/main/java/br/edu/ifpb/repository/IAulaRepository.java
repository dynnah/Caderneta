package br.edu.ifpb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.model.Aula;

public interface IAulaRepository extends JpaRepository<Aula, Long> {

}
