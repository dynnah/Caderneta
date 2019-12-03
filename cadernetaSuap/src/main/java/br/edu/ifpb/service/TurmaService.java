package br.edu.ifpb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.exceptions.ResourceNotFoundException;
import br.edu.ifpb.model.Turma;
import br.edu.ifpb.repository.ITurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private ITurmaRepository turmaRepository;
	
	public Turma create(Turma turma) {
		return turmaRepository.save(turma);
	}
	
	public List<Turma> getAll(){
		return turmaRepository.findAll();
	}
	
	public Optional<Turma> getOne(Long id){
		return turmaRepository.findById(id);
	}
	
	public Turma update(Long id, Turma turma) {
		Optional<Turma> turmaOpt = turmaRepository.findById(id);
		
		if(turmaOpt.isPresent()) {
			turma.setId(id);
			return turmaRepository.save(turma);
		}
		
		throw new ResourceNotFoundException(id);
	}
	
	public Turma delete(Long id) {
		Optional<Turma> turmaOpt = turmaRepository.findById(id);
		
		if(!turmaOpt.isPresent()) {
			throw new ResourceNotFoundException(id);
		}
		
		turmaRepository.deleteById(id);
		return turmaOpt.get();
	}
}
