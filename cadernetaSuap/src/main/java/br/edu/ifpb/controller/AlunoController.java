package br.edu.ifpb.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.model.Aluno;
import br.edu.ifpb.model.Usuario;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	

	
	@RequestMapping("/login")
	public ModelAndView login(@Valid Usuario login) {
		ModelAndView mav = new ModelAndView("aluno/index");
		mav.addObject("aluno", new Aluno());
		return mav;
	}
//	
//	@RequestMapping("/alunoViewDisciplina")
//	public ModelAndView visualizarDisciplinas() {
//		
//	}
//
//	@RequestMapping("/alunoViewFaltas")
//	public ModelAndView visualizarNotasEFaltas() {
//		
//	}
}
