package wang.gnim.netty.server.dao.jdbc;

import org.junit.Assert;
import org.junit.Test;

import wang.gnim.netty.server.dao.jdbc.IDQuery;

public class testIDQuery {

	@Test
	public void test() {
		int id = IDQuery.queryMaxID("test");
		Assert.assertEquals(1, id);
	}
}
