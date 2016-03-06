package org.william.handler;

import java.util.ArrayList;
import java.util.List;

import org.william.model.Produto;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ProdutoHandler extends DefaultHandler {

	public static final String EL_PRECO = "preco";
	public static final String EL_NOME = "nome";
	public static final String EL_PRODUTO = "produto";

	private Produto produto;
	private List<Produto> produtos = new ArrayList<Produto>();
	private StringBuilder conteudo = new StringBuilder();

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals(EL_PRODUTO)) {
			produto = new Produto();
		}
		if (qName.equals(EL_PRECO) || qName.equals(EL_NOME)) {
			conteudo = new StringBuilder();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		conteudo.append(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals(EL_PRODUTO)) {
			produtos.add(produto);
		}
		if (qName.equals(EL_NOME)) {
			produto.setNome(conteudo.toString());
		}
		if (qName.equals(EL_PRECO)) {
			produto.setPreco(Double.parseDouble(conteudo.toString()));
		}
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
