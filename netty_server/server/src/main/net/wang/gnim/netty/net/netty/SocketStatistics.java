package wang.gnim.netty.net.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelMetadata;

/**
 * 服务器统计
 * 1.protobuf消息执行时长
 * 2.http消息执行时长
 * 
 * TODO
 * @author wangming
 *
 */
public enum SocketStatistics {

	ISNTANCE;
	
	private void statisticProtobuf(ChannelHandlerContext ctx) {
		Channel channel = ctx.channel();
		ChannelConfig config = channel.config();
		System.out.println("ConnectTimeoutMillis : " + config.getConnectTimeoutMillis());
		System.out.println("MaxMessagesPerRead : " + config.getMaxMessagesPerRead());
		System.out.println("WriteBufferHighWaterMark : " + config.getWriteBufferHighWaterMark());
		System.out.println("WriteBufferLowWaterMark : " + config.getWriteBufferLowWaterMark());
		System.out.println("WriteSpinCount : " + config.getWriteSpinCount());
		System.out.println("isAutoRead : " + config.isAutoRead());
		ChannelMetadata meatadata = channel.metadata();
		System.out.println("ServerStatistics : " + meatadata);
		
	}
}
