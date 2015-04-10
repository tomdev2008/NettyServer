package wang.gnim.netty.server;

import wang.gnim.netty.net.netty.ActionCommandCache;
import wang.gnim.netty.net.netty.http.HttpServerFactory;
import wang.gnim.netty.net.netty.pureSocket.ProtobufServerFactory;
import wang.gnim.netty.server.core.monitors.C3P0Monitor;
import wang.gnim.netty.server.core.spring.SpringContext;

public class Server {

	public static void main(String[] args) {
		
		SpringContext.INSTANCE.getApplicationContext();
		
		ActionCommandCache.INSTANCE.init();
		
		C3P0Monitor.INSTANCE.monitor();

		HttpServerFactory.INSTANCE.start("defaults", 10021);
		
		ProtobufServerFactory.INSTANCE.start(8080);
	}
}
