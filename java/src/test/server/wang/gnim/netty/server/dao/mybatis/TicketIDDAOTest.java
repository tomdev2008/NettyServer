package wang.gnim.netty.server.dao.mybatis;

import org.junit.Assert;
import org.junit.Test;

import wang.gnim.netty.server.MockServer;
import wang.gnim.netty.server.bean.TicketID;
import wang.gnim.netty.server.dao.mybatis.TicketIDDAO;

public class TicketIDDAOTest {

	@Test
	public void test32ID() {
		
		MockServer.start();
		TicketID tid = new TicketID();
		tid.setStub("a");
		TicketIDDAO.getInstance().get64ID(tid);
		Assert.assertEquals(1, tid.getId());
	}
}
