package br.edu.ifpb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import br.edu.ifpb.exceptions.ResourceNotFoundException;
import br.edu.ifpb.model.Usuario;
import br.edu.ifpb.repository.IUsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	public Usuario create(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public List<Usuario> getAll(){
		return usuarioRepository.findAll();
	}
	
	public Optional<Usuario> getOne(Long id, Usuario usuario){
		return usuarioRepository.findById(id);
	}
	
	public Usuario update(Long id, Usuario usuario) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
		
		if(usuarioOpt.isPresent()) {
			usuario.setId(id);
			return usuarioRepository.save(usuario);
		}
		
		throw new ResourceNotFoundException(id);
	}
	
	public Usuario delete(Long id) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
		
		if(!usuarioOpt.isPresent()) {
			throw new ResourceNotFoundException(id);
		}
		
		usuarioRepository.deleteById(id);
		return usuarioOpt.get();
	}	
	
}
