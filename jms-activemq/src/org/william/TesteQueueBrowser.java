package org.william;

import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class TesteQueueBrowser {
	public static void main(String[] args) throws Exception {
		InitialContext ctx = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
		Connection conn = factory.createConnection();
		conn.start();
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = (Destination) ctx.lookup("financeiro");
		QueueBrowser browser = session.createBrowser((Queue) destination);
		Enumeration<Message> enumeration = browser.getEnumeration();
		// Mensagens não consumidas
		while (enumeration.hasMoreElements()) {
			TextMessage txtMsg = (TextMessage) enumeration.nextElement();
			System.out.println(txtMsg.getText());
		}
		session.close();
		conn.close();
		ctx.close();
	}
}
