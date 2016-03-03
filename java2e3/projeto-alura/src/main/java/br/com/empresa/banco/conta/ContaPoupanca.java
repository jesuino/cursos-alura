package br.com.empresa.banco.conta;

public class ContaPoupanca extends Conta {

	@Override
	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa;
	}
	
	@Override
	public int compareTo(ContaPoupanca o) {
		return getNome().compareTo(o.getNome());
	}

}