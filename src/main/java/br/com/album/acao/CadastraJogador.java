package br.com.album.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.album.model.ConnectionFactory;
import br.com.album.model.Figurinha;

public class CadastraJogador implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		ConnectionFactory connectionFactory = new ConnectionFactory();

		String jogador = request.getParameter("jogador");
		int numero = Integer.valueOf(request.getParameter("numero"));
		String selecao = request.getParameter("selecao");
		String query = "INSERT INTO figurinha(jogador,numero,selecao) values (?,?,?)";

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = connectionFactory.iniciaConexao();
			PreparedStatement stm = conn.prepareStatement(query);
//			stm.execute("SELECT ID, JOGADOR, NUMERO, SELECAO FROM FIGURINHA");
//			ResultSet rs = stm.getResultSet();
			
//			while (rs.next()) {
//				Figurinha figurinha = new Figurinha();
//				figurinha.setId(rs.getInt("id"));
//				figurinha.setJogador(rs.getString("jogador"));
//				figurinha.setNumero(rs.getInt("numero"));
//				figurinha.setSelecao(rs.getString("selecao"));
//				if(figurinha.ehIgual(jogador, numero, selecao)) {
//					System.out.println("Figurinha já existe");
//					return "redirect:controller?acao=ListaFigurinhas";
					
//				}else {
					stm.setString(1, jogador);
					stm.setInt(2, numero);
					stm.setString(3, selecao);
					stm.executeUpdate();
					stm.close();
					conn.close();
					return "redirect:controller?acao=ListaFigurinhas";
//				}
//			}
			
			

		} catch (Exception e) {
			System.out.println("Deu erro");
		}
		return null;

		
	}

}
