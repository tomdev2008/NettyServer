package wang.gnim.netty.server.action.test;

import io.robertsing.nettyserver.messages.MsgId.MsgID;
import io.robertsing.nettyserver.messages.TestMessage.TestRequest;
import io.robertsing.nettyserver.messages.TestMessage.TestResponse;

import org.junit.Assert;
import org.junit.Test;

import wang.gnim.netty.server.MockServer;

public class TestActionTest {

	@Test
	public void test() {
		MockServer server = MockServer.start();
		
		TestRequest test = TestRequest.newBuilder()
				.setMsgID(MsgID.TEST)
				.build();

		TestResponse response = (TestResponse)server.execute(MsgID.TEST, test);
		Assert.assertEquals(MsgID.TEST, response.getMsgID());
	}
	
}
