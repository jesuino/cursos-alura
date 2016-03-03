class Conta {
	protected double saldo;


	public double getSaldo() {
		return this.saldo;
	}

	public void deposita(double valor) {
		this.saldo += valor;
	}

	public void saca(double valor) {
		this.saldo -= valor;
	}

	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa;
	}
}
class ContaCorrente extends Conta {

	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa * 2;
	}
}

class ContaPoupanca extends Conta {
}
