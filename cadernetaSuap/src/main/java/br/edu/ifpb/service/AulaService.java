package br.edu.ifpb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.exceptions.ResourceNotFoundException;
import br.edu.ifpb.model.Aula;
import br.edu.ifpb.repository.IAulaRepository;

@Service
public class AulaService {
	
	@Autowired
	private IAulaRepository aulaRepository;
	
	public Aula create(Aula aula) {
		return aulaRepository.save(aula);
	}
	
	public List<Aula> getAll(){
		return aulaRepository.findAll();
	}
	
	public Optional<Aula> getOne(Long id){
		return aulaRepository.findById(id);
	}
	
	public Aula update(Long id, Aula aula) {
		Optional<Aula> aulaOpt = aulaRepository.findById(id);
		
		if(aulaOpt.isPresent()) {
			aula.setId(id);
			return aulaRepository.save(aula);
		}
		
		throw new ResourceNotFoundException(id);
	}
	
	public Aula delete(Long id) {
		Optional<Aula> aulaOpt = aulaRepository.findById(id);
		
		if(!aulaOpt.isPresent()) {
			throw new ResourceNotFoundException(id);
		}
		
		aulaRepository.deleteById(id);
		return aulaOpt.get();
	}

}
