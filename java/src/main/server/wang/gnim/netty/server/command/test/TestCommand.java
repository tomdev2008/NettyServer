package wang.gnim.netty.server.command.test;

import wang.gnim.netty.net.netty.http.HttpParamaters;
import wang.gnim.netty.server.command.AbstractCommand;

public class TestCommand extends AbstractCommand {


	@Override
	public String execute(HttpParamaters param) {
		for (String key : param.parameters.keySet()) {
			System.out.println("TestCommand " + key);
		}
		return "test response";
	}

}
