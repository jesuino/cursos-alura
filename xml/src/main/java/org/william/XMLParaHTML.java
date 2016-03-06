package org.william;

import java.io.InputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XMLParaHTML {
	public static void main(String[] args) throws Exception {
		InputStream xml = XMLParaHTML.class.getResourceAsStream("/vendas.xml");
		StreamSource xmlSource = new StreamSource(xml);
		InputStream xls = XMLParaHTML.class.getResourceAsStream("/vendas.xslt");
		StreamSource xlsSource = new StreamSource(xls);
		StreamResult saida = new StreamResult("vendas.html");
		Transformer transformer = TransformerFactory.newInstance().newTransformer(xlsSource);
		transformer.transform(xmlSource, saida);
		System.out.println("Arquivo transformado!");

	}
}
