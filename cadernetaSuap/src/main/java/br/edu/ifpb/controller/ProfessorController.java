package br.edu.ifpb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.model.Professor;
import br.edu.ifpb.model.Turma;
import br.edu.ifpb.repository.IProfessorRepository;
import br.edu.ifpb.service.AlunoService;
import br.edu.ifpb.service.AulaService;
import br.edu.ifpb.service.DisciplinaService;
import br.edu.ifpb.service.ProfessorService;
import br.edu.ifpb.service.TurmaService;

@Controller
public class ProfessorController {

	@Autowired
	private final IProfessorRepository professorRepository;
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private AulaService aulaService;
	
	@Autowired
	private TurmaService turmaService;
	
	public ProfessorController(IProfessorRepository professorRepository) {
		super();
		this.professorRepository = professorRepository;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, editor);
	}
	
	
//	@RequestMapping
//	public ModelAndView fazerLogin(){
//		
//	}
	
//	@RequestMapping
//	public ModelAndView registrarAula(){
//		
//		
//	}
//	
//	@RequestMapping
//	public ModelAndView lancarNota(){
//		
//	}
		
	@RequestMapping
	public ModelAndView visualizarCaderneta() {
		
		return new ModelAndView("professor");
	}
	
//	@RequestMapping("/visualizarTurmas")
//	public ModelAndView visualizarTrumas() {
//		turmaService.getAll();
//		attr.addFlashAttribute("mensagem", "Veja a turma toda!!");
//		return new ModelAndView("redirect:visualizarTurmas");
//	}
}
