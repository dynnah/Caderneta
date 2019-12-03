package br.edu.ifpb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.exceptions.ResourceNotFoundException;
import br.edu.ifpb.model.Aluno;
import br.edu.ifpb.repository.IAlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private IAlunoRepository alunoRepository;
	
	public Aluno create(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public List<Aluno> getAll(){
		return alunoRepository.findAll();
	}
	
	public Optional<Aluno> getOne(long id){
		return alunoRepository.findById(id);
	}
	
	public Aluno update(Long id, Aluno aluno) {
		Optional<Aluno> alunoOpt = alunoRepository.findById(id);
		
		if(alunoOpt.isPresent()) {
			aluno.setId(id);
			return alunoRepository.save(aluno);
		}
		
		throw new ResourceNotFoundException(id);
	}
	
	public Aluno delete(Long id, Aluno aluno) {
		Optional<Aluno> alunoOpt = alunoRepository.findById(id);
		
		if(!alunoOpt.isPresent()) {
			throw new ResourceNotFoundException(id);
		}
		
		alunoRepository.deleteById(id);
		return alunoOpt.get();
	}
}
