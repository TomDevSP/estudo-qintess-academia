package com.qintess.leitura.arquivo;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Escrever {
	public static void main(String[] args) {
		try {
			FileOutputStream file = new FileOutputStream("C:\\Users\\re038316\\Documents\\file.txt");
			PrintWriter imprime = new PrintWriter(file);
			
			imprime.println("Linha 1 Coluna 1, Linha 1 Coluna 2, Linha 1 Coluna 3");
			imprime.println("Linha 2 Coluna 1, Linha 2 Coluna 2, Linha 2 Coluna 3");
			imprime.println("Linha 3 Coluna 1, Linha 3 Coluna 2, Linha 3 Coluna 3");
			
			imprime.close();
			file.close();
			
		} catch (Exception e) {
			System.out.println("Erro para escrever arquivo");		
		}
	}

}
