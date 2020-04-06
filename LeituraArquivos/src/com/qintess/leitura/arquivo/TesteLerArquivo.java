package com.qintess.leitura.arquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TesteLerArquivo {
	public static void main(String[] args) {
		int opcao = 0;
		Scanner leitorTerminal = new Scanner(System.in);
		
		do {
			System.out.println("\n ==== Atenção! Todos os arquivos são criados/salvos e lidos/buscados do Desktop === \n");
			System.out.println("========================================================================================");
			System.out.println("Informe a opção que deseja realizar:");
			System.out.println("========================================================================================");
			System.out.println("1 - Criar/Salvar um arquivo em disco");
			System.out.println("2 - Ler/Buscar um arquivo em disco");
			System.out.println("3 - Sair do programa");
			System.out.println("========================================================================================");
			System.out.print("=> ");
			
			opcao = leitorTerminal.nextInt();
			
			switch (opcao) {
			case 1: salvaArquivo();
					break;
			case 2: lerArquivo();
					break;
			case 3: System.out.println("Obrigado por utilizar o programa!");
					break;
			default: System.out.println("Opção não implementada pelo sistema");
					break;
			}
			
		} while (opcao != 3);
	}
	
	public static void salvaArquivo() {
		Scanner leitorTerminal = new Scanner(System.in);
		
		System.out.println("================================");
		System.out.println("Informe o contéudo do arquivo");
		System.out.println("================================");
		
		String conteudoDoArquivo = leitorTerminal.nextLine();
		
		System.out.println("================================");
		System.out.println("Informe o nome do arquivo que deseja salvar");
		System.out.println("================================");
		
		String nomeDoArquivo = leitorTerminal.next();
		
		String caminhoDoArquivo = "C:\\Users\\" + System.getProperty("user.name").toString() + "\\Desktop\\" + nomeDoArquivo + ".txt";
		
		try {
			FileWriter objEscreve = new FileWriter(caminhoDoArquivo, false);
			
			objEscreve.write(conteudoDoArquivo.toString());
			objEscreve.close();
			
			System.out.println("================================");
			System.out.println("Arquivo salvo com sucesso no diretório abaixo:");
			System.out.println("================================");
			System.out.println(caminhoDoArquivo);			
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void lerArquivo() {
		Scanner leitorTerminal = new Scanner(System.in);
		
		System.out.println("================================");
		System.out.println("Informe o arquivo que deseja ler");
		System.out.println("================================");
		
		String nomeDoArquivo = leitorTerminal.next();
		
		String caminhoDoArquivo = "C:\\Users\\" + System.getProperty("user.name").toString() + "\\Desktop\\" + nomeDoArquivo + ".txt";
		
		try {
			FileReader arquivoLer = new FileReader(caminhoDoArquivo);
			
			BufferedReader leitorArquivo = new BufferedReader(arquivoLer);
			
			String linha = leitorArquivo.readLine();
			
			while(linha != null) {
				System.out.println(linha);
				linha = leitorArquivo.readLine();
			}
			
			System.out.println("\n");
			leitorArquivo.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
