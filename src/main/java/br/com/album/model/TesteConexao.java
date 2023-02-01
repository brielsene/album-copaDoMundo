package br.com.album.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteConexao {
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.iniciaConexao();
		
		String query = "INSERT INTO figurinha(jogador,numero,selecao) values (?,?,?)";
		String nome = "Joal";
		int numero = 154;
		String selecao = "selecao";
		
		PreparedStatement stm = conn.prepareStatement(query);
		stm.setString(1, nome);
		stm.setInt(2, numero);
		stm.setString(3, selecao);
		
		 stm.executeUpdate();
		    stm.close();
		    
			conn.close(); 
			
	}
	
	

}
