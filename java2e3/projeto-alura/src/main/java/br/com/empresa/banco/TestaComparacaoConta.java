package br.com.empresa.banco;

import br.com.empresa.banco.conta.Conta;
import br.com.empresa.banco.conta.ContaCorrente;

public class TestaComparacaoConta {
	
	public static void main(String[] args) {
		Conta c1 = new ContaCorrente();
		Conta c2 = new ContaCorrente();
		c1.setNumero(10);
		c1.setNome("Jesuino");
		
		c2.setNumero(10);
		c2.setNome("Mary");
		System.out.println(c1.equals(c2));

	}

}
