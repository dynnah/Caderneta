package br.edu.ifpb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.exceptions.ResourceNotFoundException;
import br.edu.ifpb.model.Disciplina;
import br.edu.ifpb.repository.IDisciplinaRepository;

@Service
public class DisciplinaService {
	
	@Autowired
	private IDisciplinaRepository disciplinaRepository;
	
	public Disciplina create(Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}
	
	public List<Disciplina> getAll(){
		return disciplinaRepository.findAll();
	}
	
	public Optional<Disciplina> getOne(Long id){
		return disciplinaRepository.findById(id);
		
	}
	
	public Disciplina update(Long id, Disciplina disciplina) {
		Optional<Disciplina> disciplinaOpt = disciplinaRepository.findById(id);
		
		if(disciplinaOpt.isPresent()) {
			disciplina.setId(id);
			return (Disciplina)disciplinaRepository.save(disciplina);
		}
		
		throw new ResourceNotFoundException(id);
	}
	
	public Disciplina delete(Long id) {
		Optional<Disciplina> disciplinaOpt = disciplinaRepository.findById(id);
		
		if(!disciplinaOpt.isPresent())
			throw new ResourceNotFoundException(id);
		
		disciplinaRepository.deleteById(id);
		return disciplinaOpt.get();		
	}
	
	public Disciplina findByCodigo(String codigo){
		Optional<Disciplina> disciplinaCodigo = disciplinaRepository.findByCodigo(codigo);
		
		if(!disciplinaCodigo.isPresent()) {
			throw new ResourceNotFoundException(codigo);
		}	
		
		return disciplinaCodigo.get();
	}

}
