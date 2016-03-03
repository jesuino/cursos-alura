package org.william;

import java.util.Collection;

public class ProduzMensagens implements Runnable {
	private int comeco;
	private int fim;
	private Collection<String> mensagens;

	public ProduzMensagens(int comeco, int fim, Collection<String> mensagens) {
		this.comeco = comeco;
		this.fim = fim;
		this.mensagens = mensagens;
	}

	public void run() {
		for (int i = comeco; i < fim; i++) {
				mensagens.add("Mensagem " + i);
		}
	}
}