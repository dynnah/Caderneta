package br.edu.ifpb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.model.Aluno;
import br.edu.ifpb.model.Disciplina;
import br.edu.ifpb.model.Professor;
import br.edu.ifpb.model.Turma;
import br.edu.ifpb.repository.ICoordenadorRepository;
import br.edu.ifpb.service.AlunoService;
import br.edu.ifpb.service.DisciplinaService;
import br.edu.ifpb.service.ProfessorService;
import br.edu.ifpb.service.TurmaService;

@Controller
@RequestMapping("/coordenador")
public class CoordenadorController {
	@Autowired
	private final ICoordenadorRepository coordenadorRepository;
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private TurmaService turmaService;
		
	
	public CoordenadorController(ICoordenadorRepository coordenadorRepository) {
		super();
		this.coordenadorRepository = coordenadorRepository;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, editor);
	}
	
	@RequestMapping("/criarDisciplina")
	public ModelAndView criarDisciplina(Disciplina disciplina, RedirectAttributes attr) {
		disciplinaService.create(disciplina);
		attr.addFlashAttribute("mensagem", "Disciplina cadastrada com sucesso !!");		
		return new ModelAndView("redirect:cadastroDisciplina");
	}
	
	@RequestMapping("/cadastrarProfessor")
	public ModelAndView cadastrarProfessor(Professor professor, RedirectAttributes attr){
		professorService.create(professor);
		attr.addFlashAttribute("mensagem", "Professor Cadastrado com sucesso !!");
		return new ModelAndView("redirect:cadastroProfessor");
	}
	
	@RequestMapping("/matricularAluno")
	public ModelAndView matricular(Aluno aluno, RedirectAttributes attr){
		alunoService.create(aluno);
		attr.addFlashAttribute("mensagem", "Aluno matriculado com sucesso !!");
		return new ModelAndView("redirect:matricularAluno");
	}
	
	@RequestMapping("/cadastrarProfessorDisciplina")
	public ModelAndView cadastrarProfessorDisciplina(Professor professor, Disciplina disciplina, RedirectAttributes attr) {
		
		attr.addFlashAttribute("mensagem", "Professor Cadastrado com sucesso !!");
		return new ModelAndView("redirect:cadastroProfessor");
	}
	
	@RequestMapping("/cadastrarTurma")
	public ModelAndView cadastrarTurma(Turma turma, RedirectAttributes attr) {
		turmaService.create(turma);
		attr.addFlashAttribute("mensagem", "Turma Cadastrado com sucesso !!");
		return new ModelAndView("redirect:addClass");
	}
	
	@RequestMapping("/visualizarDisciplina")
	public ModelAndView visualizarDisciplina(String codigoDisciplina, RedirectAttributes attr) {
		disciplinaService.findByCodigo(codigoDisciplina);
		attr.addFlashAttribute("mensagem", "Disciplina encontrada com sucesso !!");
		return new ModelAndView("redirect:visualizarDisciplina");
	}
	
	
}
