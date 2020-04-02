package com.jdbc.desafio.database;

public class App 
{
    public static void main( String[] args )
    {
        LivrariaConecta conexao = new LivrariaConecta();
        String sql = "INSERT into genero (idgenero, descricao)" + "values(default, 'Ficção')"; 
        
        int saida = conexao.ExecutaLivraria(sql);
        if(saida > 0) {
        	System.out.println("Cadastrado com sucesso!");
        } else {
        	System.out.println("Erro durante o cadastro");
        }
    }
}
