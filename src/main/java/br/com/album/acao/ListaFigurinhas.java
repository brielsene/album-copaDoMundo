package br.com.album.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.album.model.ConnectionFactory;
import br.com.album.model.Figurinha;

public class ListaFigurinhas implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		List<Figurinha>listaFigurinha = new ArrayList<>();
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			
			Connection conn = connectionFactory.iniciaConexao();
			Statement stm = conn.createStatement();
			stm.execute("SELECT ID, JOGADOR, NUMERO, SELECAO FROM FIGURINHA");
			ResultSet rs = stm.getResultSet();
			while(rs.next()) {
				Figurinha figurinha = new Figurinha();
				figurinha.setId(rs.getInt("id"));
				figurinha.setJogador(rs.getString("jogador"));
				figurinha.setNumero(rs.getInt("numero"));
				figurinha.setSelecao(rs.getString("selecao"));
				listaFigurinha.add(figurinha);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("lista", listaFigurinha);
		
		
		
		
		return "forward:listaFigurinhas.jsp";
	}

}
