package wang.gnim.netty.server.dao.mybatis;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import wang.gnim.netty.server.MockServer;
import wang.gnim.netty.server.dao.mybatis.TestDAO;

public class TestDAOTest {

	@Test
	public void test_() {
		MockServer.start();
		
		List<wang.gnim.netty.server.bean.Test> list = TestDAO.getInstance().select();
		Assert.assertEquals(1, list.size());
	}
}
