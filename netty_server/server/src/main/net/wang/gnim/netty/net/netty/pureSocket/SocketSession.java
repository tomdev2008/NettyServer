package wang.gnim.netty.net.netty.pureSocket;

import com.google.protobuf.MessageLite;

import io.netty.channel.ChannelHandlerContext;

public class SocketSession {

	private ChannelHandlerContext context;

	public void setContext(ChannelHandlerContext context) {
		this.context = context;
	}
	
	public void write(Object msg) {
		context.writeAndFlush(msg);
	}
	
	public void write(MessageLite msg) {
		context.writeAndFlush(msg);
	}
}
