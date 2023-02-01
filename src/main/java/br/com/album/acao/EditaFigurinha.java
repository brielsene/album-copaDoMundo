package br.com.album.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.album.model.ConnectionFactory;

public class EditaFigurinha implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		int id = Integer.valueOf(request.getParameter("id"));
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection conn = new ConnectionFactory().iniciaConexao();
			PreparedStatement stm = conn.prepareStatement("UPDATE figurinha SET jogador = ?, numero = ?, selecao = ?"+ "WHERE id=?");
			stm.setString(1, request.getParameter("jogador"));
			stm.setInt(2, Integer.valueOf(request.getParameter("numero")));
			stm.setString(3, request.getParameter("selecao"));
			stm.setInt(4, id);
			stm.execute();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:controller?acao=ListaFigurinhas";
	}

}
