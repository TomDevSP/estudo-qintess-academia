package com.qintess.leitura.arquivo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoCSV {
	public static void main(String[] args) throws IOException {
		String csvArquivo = "C:\\Users\\re038316\\Documents\\desafio\\DadosMercado.csv";
		
		BufferedReader csvConteudo = null;
		
		String linha = "";
		
		String csvSeparar = ";";
		
		try {
			csvConteudo = new BufferedReader(new FileReader(csvArquivo));
			
			while((linha = csvConteudo.readLine()) != null) {
				String campo[] = linha.split(csvSeparar);
				csvConteudo.close();
				System.out.println(
						"Teste = " + campo[0]
						+ ", Col 1 = " + campo[1]);
				
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} finally {
			if (csvConteudo != null) {
				try {
					csvConteudo.close();
				} catch (IOException e2) {
					System.out.println(e2.getMessage());
				}
			}
		}
	}

}
