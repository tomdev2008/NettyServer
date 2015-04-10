package wang.gnim.netty.net.rabbitMQ;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.AMQP.BasicProperties;

public enum MQClient {

	INSTANCE;
	
	private ConnectionFactory factory = new ConnectionFactory();;
	private Connection connection;
	private Channel channel;
	private BasicProperties prop = new BasicProperties();
	
	MQClient() {
//		prop..setContentType("text/x-json");
		factory.setHost("");
		factory.setPort(0);
		factory.setPassword("");
		factory.setUsername("");
		factory.setVirtualHost("");
		try {
			connection = factory.newConnection();
			channel = connection.createChannel();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(byte[] message) {
		try {
			channel.basicPublish("", "", prop, message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
