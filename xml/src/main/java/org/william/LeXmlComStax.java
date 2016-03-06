package org.william;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

import org.william.handler.ProdutoHandler;
import org.william.model.Produto;

public class LeXmlComStax {

	public static void main(String[] args) throws Exception {
		InputStream arquivo = LeXmlComStax.class.getResourceAsStream("/vendas.xml");
		XMLEventReader eventos = XMLInputFactory.newInstance().createXMLEventReader(arquivo);
		List<Produto> produtos = new ArrayList<>();
		Produto produto = null;
		String nomeTag, valor = "";
		XMLEvent evento;
		while (eventos.hasNext()) {
			evento = eventos.nextEvent();
			if (evento.isCharacters()) {
				valor = evento.asCharacters().getData();
			}
			if (evento.isStartElement()) {
				nomeTag = evento.asStartElement().getName().getLocalPart();
				if (nomeTag.equals(ProdutoHandler.EL_PRODUTO)) {
					produto = new Produto();
				}
			}
			if (evento.isEndElement()) {
				nomeTag = evento.asEndElement().getName().getLocalPart();
				switch (nomeTag) {
				case ProdutoHandler.EL_PRODUTO:
					produtos.add(produto);
					break;
				case ProdutoHandler.EL_PRECO:
					double preco = Double.parseDouble(valor);
					produto.setPreco(preco);
					break;
				case ProdutoHandler.EL_NOME:
					produto.setNome(valor);
					break;
				default:
					break;
				}
			}
		}
		System.out.println(produtos);
	}

}
