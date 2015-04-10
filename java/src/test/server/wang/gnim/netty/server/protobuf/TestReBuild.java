package wang.gnim.netty.server.protobuf;


import io.robertsing.nettyserver.messages.MsgId.MsgID;
import io.robertsing.nettyserver.messages.TestMessage;
import io.robertsing.nettyserver.messages.TestMessage.OuterTest;
import io.robertsing.nettyserver.messages.TestMessage.TestRequest;

import org.junit.Assert;
import org.junit.Test;

public class TestReBuild {

	@Test
	public void test() {
		TestMessage.TestRequest request = TestMessage.TestRequest.newBuilder()
				.setMsgID(MsgID.TEST)
				.setData1(1)
				.setData2(2)
				.build();
		
		Assert.assertEquals(1, request.getData1());
		Assert.assertEquals(2, request.getData2());
		
		OuterTest.Builder outer = OuterTest.newBuilder()
		.setRequest(request);
		
		TestRequest re = outer.getRequest();
		Assert.assertEquals(1, re.getData1());
		Assert.assertEquals(2, re.getData2());
		
	}
}
