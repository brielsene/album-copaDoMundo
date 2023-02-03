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
import javax.servlet.http.HttpSession;

import br.com.album.model.ConnectionFactory;

public class CadastroUsuario implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		
		
		if(!(request.getParameter("senha").equals(request.getParameter("senha2"))) ) {
			String msgErro = "As senhas não coicidem, tente novamente!";
			HttpSession sessao = request.getSession();
			sessao.setAttribute("msgErro", msgErro);
			return "redirect:controller?acao=FormCadastroUsuario";
			
		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		
		try(Connection conn = new ConnectionFactory().iniciaConexao();) {
			
			String sql = "INSERT INTO LOGIN (USUARIO, SENHA) values (?, ?)";
			try(PreparedStatement stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				stm.setString(1, request.getParameter("login"));
				stm.setString(2, request.getParameter("senha"));
				br.com.album.model.Login login = new br.com.album.model.Login();
				login.setUsuario(request.getParameter("login"));
				login.setSenha(request.getParameter("senha"));
				
				stm.execute();
				ResultSet rs = stm.getGeneratedKeys();
				while(rs.next()) {
					login.setId(rs.getInt(1));
					System.out.println(login.getId());
					
				}
				HttpSession sessao = request.getSession();
				sessao.setAttribute("usuarioLogado", login );
			}
		} catch (SQLException e) {
			System.out.println("erro");
		}
		
		
		return "redirect:controller?acao=ListaFigurinhas";
	}

}
