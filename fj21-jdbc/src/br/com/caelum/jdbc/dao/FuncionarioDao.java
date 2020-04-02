package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Funcionario;

public class FuncionarioDao {
	
	private Connection connection;

	public FuncionarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void AdicionaBancoFunc(Funcionario funcionario) {
		String sql = "insert into funcionario " + "(nome,usuario,senha)" + "values(?,?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			
			stmt.execute();
			stmt.close();			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Funcionario> getLista(){
		try {
			List<Funcionario> funcionario = new ArrayList<Funcionario>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from Funcionario");
			ResultSet result = stmt.executeQuery();
			
			while (result.next()) {
				Funcionario funcionario1 = new Funcionario();
				funcionario1.setId(result.getLong("id"));
				funcionario1.setNome(result.getString("nome"));
				funcionario1.setUsuario(result.getString("usuario"));
				funcionario1.setSenha(result.getString("senha"));
				
				funcionario.add(funcionario1);
			}
			result.close();
			stmt.close();
			return funcionario;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
}
