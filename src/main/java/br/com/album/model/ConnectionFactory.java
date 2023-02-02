package br.com.album.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource  = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/albumcup?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("root");
		comboPooledDataSource.setMaxPoolSize(30);
		
		this.dataSource=comboPooledDataSource;
	}
	
	
	
	
	
	public Connection iniciaConexao() throws SQLException {
		
		return this.dataSource.getConnection();
	}

}
