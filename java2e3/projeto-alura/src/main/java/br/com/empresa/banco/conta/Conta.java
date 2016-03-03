package br.com.empresa.banco.conta;

public abstract class Conta implements Comparable<ContaPoupanca> {
	protected double saldo;
	private String nome;
	protected int numero;

	public double getSaldo() {
		return this.saldo;
	}

	public void deposita(double valor) throws ValorInvalidoException {
		if (valor <= 0) {
			throw new ValorInvalidoException(valor);
		}
		this.saldo += valor;
	}

	public void saca(double valor) {
		this.saldo -= valor;
	}

	public abstract void atualiza(double taxa);

	public String toString() {
		return nome + " tem saldo de R$ " + this.saldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (numero != other.numero)
			return false;
		return true;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int compareTo(ContaPoupanca o) {
		double a = this.getSaldo();
		double b = o.getSaldo();
		return Double.compare(a, b);
	}

}
