package wang.gnim.netty.net.pureSocket;

import io.robertsing.nettyserver.messages.MessagerMessage.MessagerRequest;
import io.robertsing.nettyserver.messages.MsgId.MsgID;
import io.robertsing.nettyserver.messages.TestMessage;

import java.util.concurrent.TimeUnit;

import wang.gnim.netty.net.netty.pureSocket.ProtobufClient;
import wang.gnim.netty.net.netty.pureSocket.SocketSession;
import wang.gnim.netty.net.netty.pureSocket.SocketSessionCache;


public class TestProtobufClient {
	
	public static void main(String[] args) {
		ProtobufClient.INSTANCE.connect("localhost", 8080);
		
		TestMessage.TestRequest request = TestMessage.TestRequest.newBuilder()
				.setMsgID(MsgID.TEST)
				.build();
		
		MessagerRequest messageResult = MessagerRequest.newBuilder()
				.setMsgID(MsgID.TEST)
				.setContent(request.toByteString())
				.build();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		SocketSession session = SocketSessionCache.INSTANCE.get("localhost:8080");
		session.write(messageResult);
	}
}
