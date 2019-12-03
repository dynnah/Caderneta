package br.edu.ifpb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.exceptions.ResourceNotFoundException;
import br.edu.ifpb.model.Nota;
import br.edu.ifpb.repository.INotaRepository;

@Service
public class NotaService {
	
	@Autowired
	private INotaRepository notaRepository;
	
	public Nota create(Nota nota) {
		return notaRepository.save(nota);
	}
	
	public List<Nota> getAll(){
		return notaRepository.findAll();
	}
	
	public Optional<Nota> getOne(Long id){
		return notaRepository.findById(id);
	}
	
	public Nota update(Long id, Nota nota) {
		Optional<Nota> notaOpt = notaRepository.findById(id);
		
		if(notaOpt.isPresent()) {
			nota.setId(id);
			return notaRepository.save(nota);
		}
		
		throw new ResourceNotFoundException(id);
	}
	
	public Nota delete(Long id) {
		Optional<Nota> notaOpt = notaRepository.findById(id);
		
		if(!notaOpt.isPresent()) {
			throw new ResourceNotFoundException(id);
		}
		
		notaRepository.deleteById(id);
		return notaOpt.get();
		}	

}
