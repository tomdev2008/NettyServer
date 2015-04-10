package wang.gnim.netty.server.action.test;

import wang.gnim.netty.server.action.AbstractAction;
import io.robertsing.nettyserver.messages.MsgId.MsgID;
import io.robertsing.nettyserver.messages.TestMessage.TestRequest;
import io.robertsing.nettyserver.messages.TestMessage.TestResponse;

public class TestAction extends AbstractAction<TestRequest> {

	
	@Override
	public TestResponse execute(TestRequest param) {
		System.out.println("TestAction : " + param.getMsgID());
		
		return TestResponse.newBuilder()
				.setMsgID(MsgID.TEST)
				.build();
	}

}
