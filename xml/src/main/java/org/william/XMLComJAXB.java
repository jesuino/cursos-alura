package org.william;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.william.model.Produto;
import org.william.model.Venda;

public class XMLComJAXB {

	public static void main(String[] args) throws JAXBException {
		JAXBContext ctx = JAXBContext.newInstance(Venda.class);
		xmlParaObj(ctx);
		objParaXml(ctx);
	}

	private static void objParaXml(JAXBContext ctx) throws JAXBException {
		Marshaller vendaMarshaller = ctx.createMarshaller();
		Venda venda = new Venda();
		venda.setFormaPagamento("Débito");
		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto("Culinária", 100));
		produtos.add(new Produto("Artes", 100));
		produtos.add(new Produto("Pão", 100));
		venda.setProdutos(produtos);
		StringWriter writer = new StringWriter();
		vendaMarshaller.marshal(venda, writer);
		System.out.println(writer);

	}

	private static void xmlParaObj(JAXBContext ctx) throws JAXBException {
		Unmarshaller vendaUnmarshaller = ctx.createUnmarshaller();
		Venda venda = (Venda) vendaUnmarshaller.unmarshal(XMLComJAXB.class.getResourceAsStream("/vendas.xml"));
		System.out.println(venda);
	}

}
