package wang.gnim.netty.net.netty.pureSocket;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ProtobufDecoder extends ByteToMessageDecoder {

	private static AtomicInteger count = new AtomicInteger();
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

		if (in.readableBytes() < 2) {
			return;
		}
		in.markReaderIndex();
		int length = in.readShort();
		ByteBuf msg = in.readBytes(length);
		out.add(msg.toString(Charset.forName("UTF-8")));
		
		in.resetReaderIndex();
		System.out.println(count.getAndIncrement());
	}

}