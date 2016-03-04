package org.william;

import java.io.InputStream;
import java.util.List;

import org.william.handler.ProdutoHandler;
import org.william.model.Produto;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class LeXmlComSax {

	public static void main(String[] args) throws Exception {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		ProdutoHandler produtoHandler = new ProdutoHandler();
		reader.setContentHandler(produtoHandler);
		InputStream is = LeXmlComSax.class.getResourceAsStream("/vendas.xml");
		InputSource input = new InputSource(is);
		reader.parse(input);
		List<Produto> produtos = produtoHandler.getProdutos();
		
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
		
	}
	
}
