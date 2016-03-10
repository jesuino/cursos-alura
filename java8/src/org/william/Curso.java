package org.william;

public class Curso {
	private String nome;
	private int totalAlunos;

	public Curso(String nome, int totalAlunos) {
		super();
		this.nome = nome;
		this.totalAlunos = totalAlunos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTotalAlunos() {
		return totalAlunos;
	}

	public void setTotalAlunos(int totalAlunos) {
		this.totalAlunos = totalAlunos;
	}
	
	@Override
	public String toString() {
		return "Curso '" + nome + "' - " + totalAlunos + " alunos";
	}
}
