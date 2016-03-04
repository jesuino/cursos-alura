package org.william;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Principal {
	
	
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(Principal.class.getResourceAsStream("/vendas.xml"));
		
		Element venda = document.getDocumentElement();
		NodeList list = document.getElementsByTagName("formaPagamento");
		Element formaPagamento = (Element) list.item(0);
		
		System.out.println("Moeda: " + venda.getAttribute("moeda"));
		System.out.println("Forma de pagamento: " + formaPagamento.getTextContent());
		NodeList produtos = document.getElementsByTagName("produto");
		
		System.out.println("Produtos: ");
		for (int i = 0; i < produtos.getLength(); i++) {
			Element produtoEl = (Element) produtos.item(i);
			String nome = produtoEl.getElementsByTagName("nome").item(0).getTextContent();
			String precoStr = produtoEl.getElementsByTagName("preco").item(0).getTextContent();
			Double preco = Double.parseDouble(precoStr);
			Produto produto = new Produto(nome, preco);
			System.out.println("    " + produto);
		}
	}

}
