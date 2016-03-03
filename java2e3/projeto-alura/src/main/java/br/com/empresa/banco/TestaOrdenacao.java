package br.com.empresa.banco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import br.com.empresa.banco.conta.ContaPoupanca;
import br.com.empresa.banco.conta.ValorInvalidoException;

public class TestaOrdenacao {
	
	public static void main(String[] args) throws ValorInvalidoException {
		List<ContaPoupanca> contas = new ArrayList<>();
		String nomes[] = {"John", "Marc", "Bill", "Stephan", "Mary", "Joane", "Wallace"};
		Random r = new Random();
		for(int i = 0; i < 10; i++) {
			String nome = nomes[r.nextInt(nomes.length)];
			ContaPoupanca c = new ContaPoupanca();
			double saldo = r.nextDouble() * 10000;
			c.deposita(saldo);
			c.setNome(nome);
			contas.add(c);
		}
		System.out.println(contas);
		Collections.sort(contas);
		System.out.println(contas);
	}

}
