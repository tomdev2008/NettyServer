package wang.gnim.netty.net.netty.handlers;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

import org.apache.log4j.Logger;

import wang.gnim.netty.net.netty.parser.ProtobufParse;
import wang.gnim.netty.net.netty.pureSocket.ProtobufClient;
import wang.gnim.netty.net.netty.pureSocket.SocketSession;
import wang.gnim.netty.net.netty.pureSocket.SocketSessionCache;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ProtobufHandler extends ChannelInboundHandlerAdapter {

	private final static Logger logger = Logger.getLogger(ProtobufHandler.class);

	@Override
	public void channelActive(ChannelHandlerContext ctx) {

		InetSocketAddress address = (InetSocketAddress)ctx.channel().remoteAddress();
		String remote = address.getHostName() + ":" + address.getPort();
		if (!SocketSessionCache.INSTANCE.contains(remote)) {
			SocketSession session = new SocketSession();
			session.setContext(ctx);
			SocketSessionCache.INSTANCE.put(remote, session);
			logger.debug("addSession :" + remote);
		}
	}

	/*
	 * 接受客户端的消息
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {

		logger.debug("channelRead");
		ProtobufParse.INSTANCE.parse(ctx, msg);
		
	}

	/**
	 * TODO userEventTriggered通常用于自定义事件的处理，其中IdleState就是一种。
	 * 
	 * 除了常见的Channel事件外，如果要扩展出自己的事件处理，就是调用这个方法的。
	 * 要触发，就调用这个方法就好：fireUserEventTriggered(Object)
	 */
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
			throws Exception {
		logger.debug("Server : userEventTriggered");

	}

	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		logger.error("netty channelUnregistered : " + ctx.channel());
		
		ProtobufClient.INSTANCE.shutdon();
		ProtobufClient.INSTANCE.tryConnect();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {

		SocketAddress address = ctx.channel().remoteAddress();
		logger.error(address.toString() + " -- " + cause.getMessage());
		if (logger.isDebugEnabled())
			cause.printStackTrace();

		ctx.close();// 发生异常，关闭链路
	}
}
