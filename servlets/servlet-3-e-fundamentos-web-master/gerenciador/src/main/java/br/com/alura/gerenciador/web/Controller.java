package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="controller")
public class Controller extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String alvo = req.getParameter("alvo");
		if(alvo == null) {
			IllegalArgumentException alvoNaoInformado = new IllegalArgumentException("Alvo não informado");
			throw new ServletException(alvoNaoInformado);
		}
		String classeAlvo = "br.com.alura.gerenciador.web." + alvo;
		try {
			Class<?>  clazz = Class.forName(classeAlvo);
			Tarefa instanciaAlvo = (Tarefa) clazz.newInstance();
			String destino = instanciaAlvo.executa(req, resp);
			req.getRequestDispatcher(destino).forward(req, resp);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
