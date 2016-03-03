class TestaFuncionario {

    public static void main(String[] args) {
	Funcionario f1 = new Funcionario();
	Data d1 = new Data(27, 2, 2016);
	
	f1.setNome("Hugo");
	f1.setSalario(100);
	f1.recebeAumento(50);
	f1.setDataEntrada(d1);
	f1.mostra();
    }
}
