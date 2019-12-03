package br.edu.ifpb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.exceptions.ResourceNotFoundException;
import br.edu.ifpb.model.Coordenador;
import br.edu.ifpb.repository.ICoordenadorRepository;

@Service
public class CoordenadorService {
	
	@Autowired
	private ICoordenadorRepository coordenadorRepository;
	
	public Coordenador create(Coordenador coordenador) {
		return coordenadorRepository.save(coordenador);
	}
	
	public List<Coordenador> getAll(){
		return coordenadorRepository.findAll();
	}

	public Optional<Coordenador> getOne(Long id){
		return coordenadorRepository.findById(id);
	}
	
	public Coordenador update(Long id, Coordenador coordenador) {
		Optional<Coordenador> coordenadorOpt = coordenadorRepository.findById(id);
		
		if(coordenadorOpt.isPresent()) {
			coordenador.setId(id);
			return coordenadorRepository.save(coordenador);
		}
		
		throw new ResourceNotFoundException(id);
	}
	
	public Coordenador delete(Long id, Coordenador coordenador) {
		Optional<Coordenador> coordenadorOpt = coordenadorRepository.findById(id);
		
		if(!coordenadorOpt.isPresent()) {
			throw new ResourceNotFoundException(id);
		}
		
		coordenadorRepository.deleteById(id);
		return coordenadorOpt.get();
	}
}
