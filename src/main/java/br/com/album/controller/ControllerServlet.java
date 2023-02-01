package br.com.album.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.album.acao.Acao;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		String nomeDaClasse = "br.com.album.acao."+paramAcao;
		
		String nome;
		
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao)classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
				| ServletException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		
		String tipoEEndereco [] = nome.split(":");
		if(tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/"+tipoEEndereco[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
		
		
		
	}

}
