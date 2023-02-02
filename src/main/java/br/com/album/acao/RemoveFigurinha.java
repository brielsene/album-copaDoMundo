package br.com.album.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.album.model.ConnectionFactory;

public class RemoveFigurinha implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int id = Integer.valueOf(request.getParameter("id"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try(Connection conn = new ConnectionFactory().iniciaConexao();
				PreparedStatement stm = conn.prepareStatement("DELETE FROM FIGURINHA WHERE ID = ? ");) {
			
			
			stm.setInt(1, id);
			stm.execute();
			//quando colocamos e iniciamos as variáveis dentro do try() ele automaticamente fecha após o término, tanto o conn.close() e o stm.close
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:controller?acao=ListaFigurinhas";
	}

}
