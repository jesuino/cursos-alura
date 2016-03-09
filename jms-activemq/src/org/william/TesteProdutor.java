package org.william;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;

import br.com.caelum.modelo.Pedido;
import br.com.caelum.modelo.PedidoFactory;

public class TesteProdutor {
	public static void main(String[] args) throws Exception {
		InitialContext ctx = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
		Connection conn = factory.createConnection();
		conn.start();
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = (Destination) ctx.lookup("financeiro");
		MessageProducer producer = session.createProducer(destination);
		Pedido pedido = new PedidoFactory().geraPedidoComValores();
		Message m = session.createObjectMessage(pedido);
		producer.send(m);
		session.close();
		conn.close();
		ctx.close();
	}
}
