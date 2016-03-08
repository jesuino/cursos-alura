package org.william;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;

public class TesteProdutor {
	public static void main(String[] args) throws Exception {
		InitialContext ctx = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
		Connection conn = factory.createConnection();
		conn.start();
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = (Destination) ctx.lookup("financeiro");
		MessageProducer producer = session.createProducer(destination);
		for (int i = 0; i < 1000; i++) {
			Message m = session.createTextMessage("Olá Mundo pela " + i+1 + " vez");
			producer.send(m);
		}
		session.close();
		conn.close();
		ctx.close();
	}
}
