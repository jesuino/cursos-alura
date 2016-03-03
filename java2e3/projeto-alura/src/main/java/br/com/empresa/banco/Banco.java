package br.com.empresa.banco;

import java.util.List;
import java.util.Map;

import br.com.empresa.banco.conta.Conta;

public class Banco {

	private List<Conta> contas;
	private Map<String, Conta> mapaConta;

	public void adiciona(Conta c) {
		contas.add(c);
		mapaConta.put(c.getNome(), c);
	}

	public Conta pega(int x) {
		return contas.get(x);
	}

	public int pegaQuantidadeDeContas() {
		return contas.size();
	}
	
	public Conta buscaPorNome(String nome) {
		return mapaConta.get(nome);
	}

}