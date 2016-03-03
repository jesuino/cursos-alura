class TestaEmpresa {

    public static void main(String[] args) {
	int i = 0;
	Empresa e = new Empresa(1000);
	while( i++ < 10) {
		Funcionario f1 = new Funcionario();
		Data d1 = new Data(27, 2, 2016);
		f1.setNome("Hugo");
		f1.setSalario(100);
		f1.recebeAumento(50);
		f1.setDataEntrada(d1);
		// coincidemente a empresa contratou 10 hugos no mesmo dia heheheh
		e.adiciona(f1);
	}
	e.mostraFuncionarios();

	Funcionario f1 = new Funcionario();
	Data d1 = new Data(27, 2, 2016);
	
	f1.setNome("Hugo");
	f1.setSalario(100);
	f1.recebeAumento(50);
	f1.setDataEntrada(d1);
	
	e.adiciona(f1);
	
	Funcionario f2 = new Funcionario();
	
	f2.setNome("Hugo");
	f2.setSalario(100);
	f2.recebeAumento(50);
	f2.setDataEntrada(new Data(27, 2, 2016));
	System.out.println("F1 encontrado? (true): " + e.contem(f1));	
	System.out.println("F2 encontrado? (false): " + e.contem(f2));	
    }
}
