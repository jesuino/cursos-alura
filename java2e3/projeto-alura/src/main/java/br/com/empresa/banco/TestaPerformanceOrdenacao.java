package br.com.empresa.banco;

import java.util.ArrayList;
import java.util.Collection;

public class TestaPerformanceOrdenacao {

	public static void main(String[] args) {
		Collection<Integer> teste = new ArrayList<>();
		long inicio, fim, tempo;
		int total = 1030000;

		inicio = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			teste.add(i);
		}
		fim = System.currentTimeMillis();
		tempo = fim - inicio;
		System.out.println("Tempo gasto para adicionar: " + tempo);
		inicio = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			teste.contains(i);
		}
		fim = System.currentTimeMillis();
		tempo = fim - inicio;
		System.out.println("Tempo gasto para usar contains: " + tempo);
	}
}
