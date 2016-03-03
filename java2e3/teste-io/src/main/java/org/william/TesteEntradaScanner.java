package org.william;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TesteEntradaScanner {
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new FileOutputStream("saida.txt"));
		String linha;
		while(sc.hasNextLine()) {
			linha = sc.nextLine();
			pw.println(linha);
		}
		sc.close();
		pw.close();
	}
	
}