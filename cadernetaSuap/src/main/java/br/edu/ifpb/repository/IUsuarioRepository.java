package br.edu.ifpb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{

}
