package org.william;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.naming.InitialContext;

public class TesteConsumidor {
	public static void main(String[] args) throws Exception {
		InitialContext ctx = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
		Connection conn = factory.createConnection();
		conn.start();
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination =  (Destination) ctx.lookup("financeiro");
		MessageConsumer consumer = session.createConsumer(destination);
		Message msg = consumer.receive();
		System.out.println("Mensagem: " + msg);
		session.close();
		conn.close();
		ctx.close();
	}
}
