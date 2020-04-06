package com.qintess.leitura.arquivo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Leitura {
	public static void main(String[] args) {
		try {
			FileInputStream arquivo = new FileInputStream("C:\\Users\\re038316\\Documents\\file.txt");
			InputStreamReader leia = new InputStreamReader(arquivo);
			BufferedReader carrega = new BufferedReader(leia);
			
			String linha;
			
			do {
				linha = carrega.readLine();
				if (linha != null) {
					String palavras[] = linha.split(",");
					
					System.out.println("Nova linha ----------------------------------");
					for (int i = 0; i < palavras.length; i++) {
						System.out.println("Palavra lida = " + palavras[i]);
					}
				}
				
			} while (linha != null);
			
		} catch (Exception e) {
			System.out.println("Erro ao ler arquivo");
		}
	}
}
