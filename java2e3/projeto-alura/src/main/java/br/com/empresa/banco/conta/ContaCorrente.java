package br.com.empresa.banco.conta;

import br.com.empresa.banco.sistema.Tributavel;

public class ContaCorrente extends Conta implements Tributavel {
	@Override
	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa * 2;
	}

	public double calculaTributos() {
		return this.getSaldo() * 0.01;
	}
}
