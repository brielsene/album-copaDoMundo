package br.com.album.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.album.model.ConnectionFactory;

public class MostraFigurinha implements Acao {

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
			PreparedStatement stm = conn.prepareStatement("SELECT JOGADOR, NUMERO, SELECAO FROM FIGURINHA WHERE ID = ?");
			stm.setInt(1, id );
			stm.execute();
			
			request.setAttribute("id", id);
			ResultSet rs = stm.getResultSet();
			System.out.println(rs);
			while(rs.next()) {
				request.setAttribute("jogador", rs.getString("jogador"));
				request.setAttribute("numero", rs.getInt("numero"));
				request.setAttribute("selecao", rs.getString("selecao"));
			}
			
			conn.close();

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "forward:alteraJogador.jsp";
	}

}
