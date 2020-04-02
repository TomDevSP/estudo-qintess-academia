package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {
	
	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adicionaBanco(Contato contato) {
		String sql = "insert into contatos " + "(nome,email,endereco,dataNascimento)" + "values (?,?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			ResultSet result = stmt.executeQuery();
			
			while (result.next()) {
				Contato contato = new Contato();
				contato.setId(result.getLong("id"));
				contato.setNome(result.getString("nome"));
				contato.setEmail(result.getString("email"));
				contato.setEndereco(result.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(result.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				contatos.add(contato);
			}
			result.close();
			stmt.close();
			return contatos;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void AlteraBanco(Contato contato) {
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void RemoveBanco(Contato contato) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	

}
