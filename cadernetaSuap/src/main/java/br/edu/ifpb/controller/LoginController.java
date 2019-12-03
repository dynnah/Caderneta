package br.edu.ifpb.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import br.edu.ifpb.memoriam.dao.UsuarioDAO;
//import br.edu.ifpb.memoriam.entity.Usuario;
//import br.edu.ifpb.memoriam.util.PasswordUtil;

@Controller
@RequestMapping("/login")
public class LoginController {
	
//	@Autowired
//	private UsuarioDAO usuarioDAO;
	
	
//	@RequestMapping(method=RequestMethod.GET)
//	public String loginForm(Model model, @CookieValue(value = "clogin", defaultValue = "") String clogin) {
//		Usuario u = new Usuario();
//		u.setEmail(clogin);
//		model.addAttribute(u);
//		return "login/login";
//	}
//	
//	@RequestMapping(method=RequestMethod.POST)
//	public String valideLogin(Usuario usuario, String lembrar, HttpSession session, HttpServletRequest request, HttpServletResponse resp, RedirectAttributes flash) {
//		String proxPagina = null;
//		Usuario usuarioBanco = usuarioDAO.findByLogin(usuario.getEmail());
//		if (lembrar != null && lembrar.equalsIgnoreCase("sim")) {
//			Cookie cookie = new Cookie("clogin", usuario.getEmail());
//			resp.addCookie(cookie);
//		} else {
//			for (Cookie cookie : request.getCookies()) {
//				if (cookie.getName().equals("clogin")) {
//					cookie.setValue(null);
//					cookie.setMaxAge(0);
//					resp.addCookie(cookie);
//				}
//			}
//		}
//		if (usuario.getEmail().equals(usuarioBanco.getEmail()) &&
//		usuario.getSenha().equals(usuarioBanco.getSenha())) {
//			session.setAttribute("usuario", usuarioBanco);
//			proxPagina = "redirect:contatos";
//		} else {
//			flash.addFlashAttribute("mensagem", "Login e/ou senha inválidos");
//			flash.addFlashAttribute("usuario", usuario);
//			proxPagina = "redirect:login";
//		}
//		return proxPagina;
//	}
//	
//	@RequestMapping(value="/logout", method=RequestMethod.POST)
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "redirect:/login";
//	}

}
