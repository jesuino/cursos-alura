public class AtualizadorDeContas {
    private double saldoTotal = 0;
    private double selic;

    public AtualizadorDeContas(double selic) {
	this.selic = selic;
    }

    public void roda(Conta c) {
	System.out.println("Saldo anterior: " + c.getSaldo());
	c.atualiza(selic);
	System.out.println("Saldo final: " + c.getSaldo());
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
