package org.william;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class TesteConsumidor {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		InitialContext ctx = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
		Connection conn = factory.createConnection();
		conn.start();
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = (Destination) ctx.lookup("financeiro");
		MessageConsumer consumer = session.createConsumer(destination);
		consumer.setMessageListener(m -> {
			TextMessage txtMessage = (TextMessage) m;
			try {
				System.out.println(txtMessage.getText());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		new Scanner(System.in).nextLine();
		session.close();
		conn.close();
		ctx.close();
	}
}
