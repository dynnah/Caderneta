package br.edu.ifpb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.model.Nota;

public interface INotaRepository extends JpaRepository<Nota, Long>{

}
