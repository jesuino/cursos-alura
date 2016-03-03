package org.william;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TesteEntradaEditor {
	
	
	public static void main(String[] args) throws IOException {
		String arquivo = TesteEntradaIO.class.getResource("/arquivo.txt").getFile();
		FileInputStream in = new FileInputStream(arquivo);
		Scanner sc = new Scanner(in);
		PrintWriter pw = new PrintWriter(new FileOutputStream("saida.txt"));
		String linha;
		while(sc.hasNextLine()) {
			linha = sc.nextLine();
			System.out.println(linha);
			pw.println(linha);
		}
		sc.close();
		pw.close();
	}
	
}