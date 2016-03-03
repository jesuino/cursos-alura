package br.com.empresa.banco;

import br.com.empresa.banco.conta.Conta;
import br.com.empresa.banco.conta.ContaCorrente;
import br.com.empresa.banco.conta.ContaPoupanca;
import br.com.empresa.banco.conta.ValorInvalidoException;

public class TestaContas {
	public static void main(String[] args) throws ValorInvalidoException {
		Conta c = new ContaPoupanca();
		Conta cc = new ContaCorrente();
		Conta cp = new ContaPoupanca();
		c.deposita(1000);
		cc.deposita(1000);
		cp.deposita(1000);

		c.atualiza(0.01);
		cc.atualiza(0.01);
		cp.atualiza(0.01);

		System.out.println(c.getSaldo());
		System.out.println(cc.getSaldo());
		System.out.println(cp.getSaldo());

		c.setNumero(123);
		cc.setNumero(123);
	}
}
