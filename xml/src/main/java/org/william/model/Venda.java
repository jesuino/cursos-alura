package org.william.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Venda {

	private String formaPagamento;
	private List<Produto> produtos;

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@XmlElementWrapper(name="produtos")
	@XmlElement(name="produto")
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	@Override
	public String toString() {
		return "Forma de pagamento: " + formaPagamento + "\nProdutos: \n" + produtos;
	}

}
