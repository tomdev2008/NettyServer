package wang.gnim.netty.net.netty.pureSocket;


import org.apache.log4j.Logger;

import wang.gnim.netty.net.netty.handlers.ProtobufHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.string.StringEncoder;
import io.robertsing.nettyserver.messages.MessagerMessage.MessagerRequest;

/**
 * netty socket 客户端连接
 * 
 * 
 * @author wangming
 *
 */
public enum ProtobufClient {

	INSTANCE;

	private static final Logger logger = Logger.getLogger(ProtobufClient.class);
	private EventLoopGroup group;
	private Object lock = new Object();
	
	public void tryConnect() {
		if(group == null) {
			synchronized (lock) {
				if(group == null) {
					if(connect("", 1)) {
						return;
					}
					if(connect("", 1)) {
						return;
					}
					
				}
			}
		}
	}
	
	public boolean connect(String host, int port) {

		// 配置客户端NIO线程组
		try {
			group = new NioEventLoopGroup();
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class)
					.option(ChannelOption.TCP_NODELAY, true)	
					.option(ChannelOption.SO_KEEPALIVE, true)	// 设置长连接
					.option(ChannelOption.SO_TIMEOUT, 50000)	// 设置超时
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						public void initChannel(SocketChannel ch)
								throws Exception {
//							ch.pipeline().addLast(new LengthFieldPrepender(4));
							ch.pipeline().addLast(new StringEncoder());
							ch.pipeline().addLast(new ProtobufHandler());
						}
					});

			ChannelFuture f = b.connect(host, port).sync();
			if(f.isSuccess())
				return true;
			else 
				return false;
			
		} catch (final Exception e) {
			logger.error("connect failure " + host + ":" + port + "   " + e.getMessage());
			System.err.println("connect failure " + host + ":" + port + "   " + e.getMessage());
			
		} 
		
		return false;
	}

	public void shutdon() {
		group.shutdownGracefully();
		group = null;
	}
	
}
