public class Funcionario {
	static int TOTAL = 1;
	private String nome;
	private String  RG;
	private Data dataEntrada;
	private double salario;
	private int id = TOTAL;
	public Funcionario() {TOTAL++; }

	public Funcionario(String nome) { TOTAL++ ;this.nome = nome;}
	public void recebeAumento(double aumento) {
		salario+=aumento;
	}

	public double getGanhoAnual() {
		return salario * 12;
	}
	public void mostra(){
		
		System.out.println("ID: " + id);
		System.out.println("Nome: " + nome);
		System.out.println("salario atual:" + salario);
		System.out.println("ganho anual:" + getGanhoAnual());
		System.out.println("data: " + dataEntrada);
		

	}
	
	public int getId() {return this.id;}	
	
	/**
	 * Get nome.
	 *
	 * @return nome as String.
	 */
	public String getNome()
	{
	    return nome;
	}
	
	/**
	 * Set nome.
	 *
	 * @param nome the value to set.
	 */
	public void setNome(String nome)
	{
	    this.nome = nome;
	}
	
	/**
	 * Get RG.
	 *
	 * @return RG as String.
	 */
	public String getRG()
	{
	    return RG;
	}
	
	/**
	 * Set RG.
	 *
	 * @param RG the value to set.
	 */
	public void setRG(String RG)
	{
	    this.RG = RG;
	}
	
	/**
	 * Get dataEntrada.
	 *
	 * @return dataEntrada as Data.
	 */
	public Data getDataEntrada()
	{
	    return dataEntrada;
	}
	
	/**
	 * Set dataEntrada.
	 *
	 * @param dataEntrada the value to set.
	 */
	public void setDataEntrada(Data dataEntrada)
	{
	    this.dataEntrada = dataEntrada;
	}
	
	/**
	 * Get salario.
	 *
	 * @return salario as double.
	 */
	public double getSalario()
	{
	    return salario;
	}
	
	/**
	 * Set salario.
	 *
	 * @param salario the value to set.
	 */
	public void setSalario(double salario)
	{
	    this.salario = salario;
	}
}
