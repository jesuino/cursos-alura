package org.william;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;

public class TesteTopicoConsumer1 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		InitialContext ctx = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
		Connection conn = factory.createConnection();
		conn.setClientID("consumer-1");
		conn.start();
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topico = (Topic) ctx.lookup("loja");
		MessageConsumer consumer = session.createDurableSubscriber(topico, "assinatura");
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
