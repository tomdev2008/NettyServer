package wang.gnim.netty.server.action;

import com.google.protobuf.MessageLite;

/**
 * 执行Protobuf转发过来的消息处理
 * @author wangming
 *
 * @param <T>
 */
public abstract class AbstractAction<T> {
	
	public abstract MessageLite execute(T param);
}
