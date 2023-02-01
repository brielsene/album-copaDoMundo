package br.com.album.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection iniciaConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/albumcup?useTimezone=true&serverTimezone=UTC", "root", "root");
	}

}
