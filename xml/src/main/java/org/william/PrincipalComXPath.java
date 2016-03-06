package org.william;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.william.model.Produto;

public class PrincipalComXPath {
	
	
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(PrincipalComXPath.class.getResourceAsStream("/vendas.xml"));

		String exp = "/venda/produtos/produto";
		XPath xpath = XPathFactory.newInstance().newXPath();
		NodeList produtos  = (NodeList) xpath.evaluate(exp, document, XPathConstants.NODESET);
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
