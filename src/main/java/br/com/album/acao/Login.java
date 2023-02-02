package br.com.album.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.album.model.ConnectionFactory;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println(request.getParameter("login"));
		System.out.println(request.getParameter("senha"));
		String sql = "SELECT USUARIO, SENHA FROM LOGIN WHERE USUARIO = ? AND SENHA = ? ";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection conn = new ConnectionFactory().iniciaConexao();
				PreparedStatement stm = conn.prepareStatement(sql)) {

			stm.setString(1, request.getParameter("login"));
			stm.setString(2, request.getParameter("senha"));
			stm.execute();

			ResultSet rs = stm.getResultSet();
			if (rs.next()) {
				br.com.album.model.Login login = new br.com.album.model.Login();
				login.setUsuario(request.getParameter("login"));
				login.setSenha(request.getParameter("senha"));
				HttpSession sessao = request.getSession();
				sessao.setAttribute("usuarioLogado", login);
				return "redirect:controller?acao=ListaFigurinhas";
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		System.out.println("Não está cadastrado");
		return "redirect:controller?acao=FormLogin";

	}

}
