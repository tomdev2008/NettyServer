package wang.gnim.netty.server.action.test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import wang.gnim.netty.server.MockServer;

public class TestInactive {

	@Test
	public void test() {
		MockServer server = MockServer.start();
		
		try {
			TimeUnit.SECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
