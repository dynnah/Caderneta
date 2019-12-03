package br.edu.ifpb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter(filterName = "LoginFilter", urlPatterns = {"/contatos/*", "/operadoras/*"})
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession httpSession = httpRequest.getSession(false);

		if (httpSession != null) {
			String loginUser = (String) httpSession.getAttribute("loginUser");
			if (loginUser == null) {
				redirectLogin(httpRequest, httpResponse);
				return;
			}

			String uri = httpRequest.getRequestURI();
			uri = uri.replaceFirst("/memoriam-spring", "");
//			Autorizacao autorizacao = (Autorizacao) httpSession.getAttribute("autorizacao");
//			if (autorizacao.hasAccess(uri)) {
//				chain.doFilter(request, response);
//			} else {
//				redirectNaoAutorizado(httpRequest, httpResponse);
//			}
		} else {
			redirectLogin(httpRequest, httpResponse);
		}

	}

	private void redirectLogin(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws IOException {
		String baseUrl = httpRequest.getContextPath();
		String paginaLogin = baseUrl + "/index.html";
		httpResponse.sendRedirect(httpResponse.encodeRedirectURL(paginaLogin));
	}

	private void redirectNaoAutorizado(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
			throws IOException {
		String baseUrl = httpRequest.getContextPath();
		String paginaLogin = baseUrl + "/naoautorizado.jsp";
		httpResponse.sendRedirect(httpResponse.encodeRedirectURL(paginaLogin));
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
