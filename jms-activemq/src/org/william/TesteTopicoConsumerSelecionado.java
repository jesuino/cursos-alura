package org.william;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;

public class TesteTopicoConsumerSelecionado {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		InitialContext ctx = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
		Connection conn = factory.createConnection();
		conn.setClientID("consumer-3");
		conn.start();
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topico = (Topic) ctx.lookup("loja");
		// somente recebe mensagem quando o header selecionado for true
		MessageConsumer consumer = session.createDurableSubscriber(topico, "assinatura", "selecionado=true", false);
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
