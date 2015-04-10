package wang.gnim.netty.server.command;

import wang.gnim.netty.net.netty.http.HttpParamaters;

/**
 * 执行Http请求
 * 
 * @author wangming
 *
 */
public abstract class AbstractCommand {

	public abstract Object execute(HttpParamaters param);
}
