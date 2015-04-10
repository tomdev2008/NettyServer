package wang.gnim.netty.server;

import wang.gnim.netty.net.netty.ActionCommandCache;
import wang.gnim.netty.server.action.AbstractAction;
import wang.gnim.netty.server.core.spring.SpringContext;
import io.robertsing.nettyserver.messages.MsgId.MsgID;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;

public class MockServer {

	public static MockServer start() {

		SpringContext.INSTANCE.getApplicationContext();

		ActionCommandCache.INSTANCE.init();

		return new MockServer();

	}

	public MessageLite execute(MsgID msgId, MessageLite request) {
		// 获取业务层消息号和消息内容

		byte[] bytes = request.toByteArray();

		// 根据消息号找到解析器,然后解析消息内容
		Parser requestParser = ActionCommandCache.INSTANCE.getRequestParserBy(msgId
				.getNumber());
		MessageLite message = null;
		try {
			message = (MessageLite) requestParser.parseFrom(bytes);
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
		}

		// 执行业务逻辑
		AbstractAction<MessageLite> action = ActionCommandCache.INSTANCE.getAction(msgId.name());

		return action.execute(message);

	}
}
