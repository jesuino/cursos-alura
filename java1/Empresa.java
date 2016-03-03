public class Empresa {
	private String nome, cnpj;
	private Funcionario funcionarios[];	
	
	public Empresa(int t) {
		funcionarios = new Funcionario[t];
	}
	public void adiciona(Funcionario f) {
		int i = 0;
		while(funcionarios[i] != null && i++ < funcionarios.length);
		if(i == funcionarios.length) {
			throw new Error("MUTOIS FUNCIONÁRIOS!1!!111");
		} else {
			funcionarios[i] = f;		
		}
	}
	public void mostraFuncionarios() {
		for(Funcionario f : funcionarios){
			if(f != null){
				f.mostra();
			} else {
				break;
			}
		}
	}
	public boolean contem(Funcionario f) { 
		boolean encontrado = false;
		int i = 0;
		while(i < funcionarios.length && !encontrado && funcionarios[i] != null) {
			encontrado = f == funcionarios[i];
			i++;
		}
		return encontrado; 
	}

	public Funcionario getFuncionario(int i) {
		return funcionarios[i];
	}
}
