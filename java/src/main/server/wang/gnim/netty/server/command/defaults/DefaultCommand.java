package wang.gnim.netty.server.command.defaults;

import wang.gnim.netty.net.netty.http.HttpParamaters;
import wang.gnim.netty.server.command.AbstractCommand;

public class DefaultCommand extends AbstractCommand {

	@Override
	public Object execute(HttpParamaters param) {
		System.out.println(param.toString());
		return "";
	}

}
