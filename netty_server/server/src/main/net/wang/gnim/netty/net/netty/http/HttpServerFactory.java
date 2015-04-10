package wang.gnim.netty.net.netty.http;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import wang.gnim.netty.net.netty.handlers.HttpHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

public enum HttpServerFactory {

	INSTANCE;

	private final static Logger logger = Logger.getLogger(HttpServerFactory.class);
	
	private final ExecutorService executor = Executors.newCachedThreadPool();

	private final List<Integer> ports = new ArrayList<>();
	
	public void start(String shcame, int serverPort) {
		
		if(ports.contains(serverPort))
			throw new RuntimeException(serverPort + " has started!! ");
		
		executor.execute(new NettyHttpServer(shcame, serverPort));
	}

	private static class NettyHttpServer implements Runnable {
		
		final String shcame;
		final int port;

		NettyHttpServer(String shcame, int serverPort) {
			this.shcame = shcame;
			this.port = serverPort;
		}

		@Override
		public void run() {

			EventLoopGroup bossGroup = new NioEventLoopGroup();
			EventLoopGroup workerGroup = new NioEventLoopGroup();
			try {
				ServerBootstrap b = new ServerBootstrap();
				b.group(bossGroup, workerGroup)
						.channel(NioServerSocketChannel.class)
						.childHandler(new ChannelInitializer<SocketChannel>() {
							@Override
							protected void initChannel(SocketChannel ch)
									throws Exception {
								ch.pipeline().addLast("http-decoder",
										new HttpRequestDecoder());			// TODO
								ch.pipeline().addLast("http-aggregator",
										new HttpObjectAggregator(65536));	// TODO
								ch.pipeline().addLast("http-encoder",
										new HttpResponseEncoder());			// TODO
								ch.pipeline().addLast("http-chunked",
										new ChunkedWriteHandler());			// TODO
								ch.pipeline().addLast("ServerHandler",
										new HttpHandler());
							}
						});
				
				ChannelFuture future = b.bind(port).sync();
				logger.info(shcame + " HTTP Server(based Netty) Started at " + port);

				future.channel().closeFuture().sync();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				logger.info(shcame + " http server shut down!");
				bossGroup.shutdownGracefully();
				workerGroup.shutdownGracefully();
			}

		}

	}
}
