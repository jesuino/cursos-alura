public class Data {
	private int ano, dia, mes;	
	
	public Data(int dia, int mes, int ano) {
		this.mes = mes;
		this.ano = ano;
		this.dia = dia;
	}	
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}
	
	private void testaData() {
		boolean foraDosValores = mes > 12 || dia > 31 || (mes == 2 && dia > 29);
		boolean menorQueUm = mes < 1 || ano < 1 || dia < 1;
		// outras possíveis validações....
		if(foraDosValores || menorQueUm) {
			throw new Error("impossível ter uma data com esses valores hehehe");
		} 
	}	
}
