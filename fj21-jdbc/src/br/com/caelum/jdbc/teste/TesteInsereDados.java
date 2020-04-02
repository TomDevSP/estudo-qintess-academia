package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TesteInsereDados {

	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Tom");
		contato.setEmail("tom.dylan89@gmail.com");
		contato.setEndereco("Avenida Vila Ema, 1899");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		
		dao.adicionaBanco(contato);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Dog Nino");
		funcionario.setUsuario("Nino");
		funcionario.setSenha("auauau");
		
		FuncionarioDao func = new FuncionarioDao();
		
		func.AdicionaBancoFunc(funcionario);
		
		System.out.println("Obrigado por se cadastrar!");

	}

}
