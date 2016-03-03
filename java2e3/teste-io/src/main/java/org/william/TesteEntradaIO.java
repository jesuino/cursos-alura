package org.william;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TesteEntradaIO {
	
	
	public static void main(String[] args) throws IOException {
		String arquivo = TesteEntradaIO.class.getResource("/arquivo.txt").getFile();
		BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream(arquivo)));
		System.out.println(br.readLine());
		br.close();
	}
	
}