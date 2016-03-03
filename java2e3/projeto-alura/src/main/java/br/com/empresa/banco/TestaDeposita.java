package br.com.empresa.banco;

import br.com.empresa.banco.conta.Conta;
import br.com.empresa.banco.conta.ContaCorrente;
import br.com.empresa.banco.conta.ValorInvalidoException;

public class TestaDeposita {
	
	public static void main(String[] args) {
		Conta c = new ContaCorrente();
		try {
			c.deposita(-10);
		} catch (ValorInvalidoException e) {
			System.out.println(e);
		}
	}

}
