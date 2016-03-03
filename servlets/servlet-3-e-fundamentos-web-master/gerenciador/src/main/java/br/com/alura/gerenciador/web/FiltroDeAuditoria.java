package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc)
			throws IOException, ServletException {
		HttpServletRequest r = (HttpServletRequest) req;
		String usrStr = "<desconhecido>";
		Usuario usuario = (Usuario) r.getSession().getAttribute("usuarioLogado");
		if (usuario != null) {
			usrStr = usuario.getEmail();
		}
		System.out.println("Usuário " + usrStr + " acessando a URI: " + r.getRequestURI());
		fc.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
