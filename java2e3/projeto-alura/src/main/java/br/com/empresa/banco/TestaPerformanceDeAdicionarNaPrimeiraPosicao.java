package br.com.empresa.banco;

import java.util.LinkedList;
import java.util.List;

public class TestaPerformanceDeAdicionarNaPrimeiraPosicao {
	public static void main(String[] args) {
		System.out.println("Iniciando...");
		long inicio = System.currentTimeMillis();

		// trocar depois por ArrayList
		List<Integer> teste = new LinkedList<>();

		for (int i = 0; i < 30000; i++) {
			teste.add(0, i);
		}
		//  comentar as linhas a seguir se quiser testar só o add
		inicio = System.currentTimeMillis();
		for (int i = 0; i < 30000; i++) {
			teste.get(i);
		}

		long fim = System.currentTimeMillis();
		double tempo = (fim - inicio) / 1000.0;
		System.out.println("Tempo gasto: " + tempo);
	}
}