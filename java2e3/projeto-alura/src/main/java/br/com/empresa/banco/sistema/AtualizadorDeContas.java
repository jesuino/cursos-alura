package br.com.empresa.banco.sistema;

import br.com.empresa.banco.conta.Conta;

public class AtualizadorDeContas {
    private double saldoTotal = 0;
    private double selic;

    public AtualizadorDeContas(double selic) {
	this.selic = selic;
    }

    public void roda(Conta c) {
	System.out.printf("Saldo anterior: %.2f\n", c.getSaldo());
	c.atualiza(selic);
	System.out.printf("Saldo final :%.2f\n", c.getSaldo());
	saldoTotal += c.getSaldo();
    }

    
    /**
     * Get saldoTotal.
     *
     * @return saldoTotal as double.
     */
    public double getSaldoTotal()
    {
        return saldoTotal;
    }
    
    /**
     * Set saldoTotal.
     *
     * @param saldoTotal the value to set.
     */
    public void setSaldoTotal(double saldoTotal)
    {
        this.saldoTotal = saldoTotal;
    }
}
