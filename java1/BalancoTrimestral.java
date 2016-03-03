public class BalancoTrimestral {
	public static void main(String args[]) {
        	int gastosJaneiro = 15000;
		int gastosFevereiro = 23000;
		int gastosMarco = 17000;
		int gastosTrimestre = gastosJaneiro + gastosFevereiro + gastosMarco;
		int mediaTrimestral = gastosTrimestre / 3;
		System.out.println("Gastos trimestre: " + gastosTrimestre);
		System.out.println("Média Trimestral:  " + mediaTrimestral);
        }
}
