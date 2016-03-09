package org.william;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;

public class TesteTopicoProducer {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		InitialContext ctx = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
		Connection conn = factory.createConnection();
		conn.start();
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination topico = (Destination) ctx.lookup("loja");
		MessageProducer producer = session.createProducer(topico);
		Message m = session.createTextMessage("Olá Mundo Tópico");
		System.out.println("Mandar para selecionado? (digite qualquer coisa)");
		String selecionado = new Scanner(System.in).nextLine();
		m.setBooleanProperty("selecionado", !selecionado.isEmpty());
		producer.send(m);
		session.close();
		conn.close();
		ctx.close();
	}
}

