package wang.gnim.netty.net.netty.pureSocket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

	private final ExecutorService executor = Executors.newCachedThreadPool();

	private static final Logger logger = Logger.getLogger(ProtobufClient.class);

	public void connect(String host, int port) {

		// 等待与远端创建完连接之后,才完成阻塞,进行消息通信
		
		// XXX NettyRunnable 在新的线程中启动，有问题,目前只要连接完毕,就会断开连接
		executor.execute(new NettyRunnable(host, port));
		
		logger.debug("connect over!");
	}

	private static class NettyRunnable implements Runnable {

		private final int port;
		private final String host;

		protected NettyRunnable(String host, int port) {
			this.host = host;
			this.port = port;
		}

		@Override
		public void run() {
			// 配置客户端NIO线程组
			EventLoopGroup group = new NioEventLoopGroup();
			try {
				Bootstrap b = new Bootstrap();
				b.group(group)
				.channel(NioSocketChannel.class)
				.option(ChannelOption.TCP_NODELAY, true)
				.handler(new ChannelInitializer<SocketChannel>() {
					@Override
					public void initChannel(SocketChannel ch) throws Exception {
						ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
						ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
						MessagerRequest req = MessagerRequest.getDefaultInstance();
						ch.pipeline().addLast(new ProtobufDecoder(req)); // ProtobufDecoder解码器
						ch.pipeline().addLast(new ProtobufEncoder()); // ProtobufDecoder编码器
						ch.pipeline().addLast(new ProtobufHandler());
					}
				});

				// 发起异步连接操作
				logger.debug("start connect " + host + ":" + port);
				ChannelFuture f = b.connect(host, port).sync();
				
				// 阻塞, 等待客户端链路关闭
				f.channel().closeFuture().sync();

			} catch(final Exception e) {
				e.printStackTrace();
				
			} finally {
				// 释放NIO线程组
				logger.info("client shutdownGracefully");
				group.shutdownGracefully();
			}

		}

	}
	
}
