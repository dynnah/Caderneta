package br.edu.ifpb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.exceptions.ResourceNotFoundException;
import br.edu.ifpb.model.Professor;
import br.edu.ifpb.repository.IProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private IProfessorRepository professorRepository;
	
	public Professor create(Professor professor) {
		return professorRepository.save(professor);
	}
	
	public List<Professor> getAll(){
		return professorRepository.findAll();
	}
	
	public Optional<Professor> getOne(Long id){
		return professorRepository.findById(id);
	}
	
	public Professor update(Long id, Professor professor) {
		Optional<Professor> professorOpt = professorRepository.findById(id);
		
		if(professorOpt.isPresent()) {
			professor.setId(id);
			return professorRepository.save(professor);
		}
		
		throw new ResourceNotFoundException(id);
	}
	
	public Professor delete(Long id) {
		Optional<Professor> professorOpt = professorRepository.findById(id);
		
		if(!professorOpt.isPresent()) {
			throw new ResourceNotFoundException(id);
		}
		professorRepository.deleteById(id);
		return professorOpt.get();
		
	}
}
