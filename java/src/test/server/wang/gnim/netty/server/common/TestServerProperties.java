package wang.gnim.netty.server.common;

import org.junit.Assert;
import org.junit.Test;

import wang.gnim.netty.server.common.ServerProperties;

public class TestServerProperties {

	@Test
	public void test() {
		Assert.assertEquals("1", ServerProperties.SERVER_ID.value);
		Assert.assertEquals("jdbc:mysql://localhost/test", ServerProperties.MYSQL_URL.value);
	}
}
