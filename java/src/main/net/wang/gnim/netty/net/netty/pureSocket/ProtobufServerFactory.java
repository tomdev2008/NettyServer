
package wang.gnim.netty.net.netty.pureSocket;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import wang.gnim.netty.net.netty.handlers.ProtobufHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import io.robertsing.nettyserver.messages.MessagerMessage;
import io.robertsing.nettyserver.messages.MessagerMessage.MessagerRequest;

public enum ProtobufServerFactory {

	INSTANCE;

	private final static Logger logger = Logger.getLogger(ProtobufServerFactory.class);
	
	private final ExecutorService executor = Executors.newCachedThreadPool();
	
	private final List<Integer> ports = new ArrayList<>();
	
	public void start(int serverPort) {
		
		if(ports.contains(serverPort))
			throw new RuntimeException(serverPort + " has started!! ");
		
		executor.execute(new NettyRunnable(serverPort));
	}

	private static class NettyRunnable implements Runnable {
		
		int serverPort;
		NettyRunnable(int serverPort) {
			this.serverPort = serverPort;
		}
		
		public void run() {
			int cpuSize = Runtime.getRuntime().availableProcessors();
			// 配置服务端的NIO线程组
			EventLoopGroup bossGroup = new NioEventLoopGroup();			// mainReactor负责监听server socket,accept新连接
			EventLoopGroup workerGroup = new NioEventLoopGroup(cpuSize);// subReactor负责多路分离已连接的socket,读写网 络数据,对业务处理功能,其扔给worker线程池完成

			try {
				ServerBootstrap b = new ServerBootstrap();
				b.group(bossGroup, workerGroup)
						.channel(NioServerSocketChannel.class)	// 设置nio类型的channel,根据channel.class来实例化ChannelFactory对象
						.option(ChannelOption.SO_BACKLOG, 128)
						.option(ChannelOption.TCP_NODELAY, true)
						.option(ChannelOption.AUTO_READ, true)
						.handler(new LoggingHandler(LogLevel.INFO))	// 设置AbstractBootstrap(bossGroup) handler,该handler每个ServerBootstrap 只有一个
						.childHandler(new ChannelInitializer<SocketChannel>() {	//有连接到达时会创建一个channel
							@Override
							public void initChannel(SocketChannel ch) {
								 // pipeline管理channel中的Handler,在channel队列中添加一个handler来处理业务
								ChannelPipeline pipeline = ch.pipeline();
								
								addHalfPacket(pipeline);
								addProtobuf(pipeline);
								addTimeout(pipeline);
								
								// 转发消息时  采用Netty 自带的线程池
								pipeline.addLast(new NioEventLoopGroup(128), new ProtobufHandler());
							}
						});

				// 绑定端口,同步等待成功
				ChannelFuture f = null;
				try {
					// 配置完成,开始绑定server,通过调用sync同步方法阻塞直到绑定成功
					f = b.bind(serverPort).sync();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				logger.info("server started at " + serverPort + " and wait channel close!!");
				// 等待服务端监听端口关闭 应用程序会一直等待,直到channel关闭
				try {
					f.channel().closeFuture().sync();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				logger.info("server started at " + serverPort);
			} finally {
				// 优雅退出,释放线程池资源 
				//关闭EventLoopGroup,释放掉所有资源包括创建的线程
				bossGroup.shutdownGracefully();
				workerGroup.shutdownGracefully();
			}
		}
		
		/**
		 * ProtobufVarint32FrameDecoder处理半包消息
		 * 此外还可使用LengthFieldBasedFrameDecoder通用半包解码器
		 * 或者继承ByteToMessageDecoder 自己处理半包消息
		 */
		private void addHalfPacket(ChannelPipeline pipeline) {
			pipeline.addLast(new ProtobufVarint32FrameDecoder());
			pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
		}
		
		/**
		 * 添加对Protobuf编解码支持
		 * @param pipeline
		 */
		private void addProtobuf(ChannelPipeline pipeline) {
			MessagerRequest req = MessagerMessage.MessagerRequest.getDefaultInstance();
			pipeline.addLast(new ProtobufDecoder(req)); // ProtobufDecoder解码器
			pipeline.addLast(new ProtobufEncoder()); // ProtobufDecoder编码器
		}
		
		
		private void addTimeout(ChannelPipeline pipeline) {
			pipeline.addFirst(new IdleStateHandler(5, 5, 10));
		}
	}
	
}
