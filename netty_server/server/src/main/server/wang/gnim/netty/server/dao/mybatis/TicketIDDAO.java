package wang.gnim.netty.server.dao.mybatis;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import wang.gnim.netty.server.bean.TicketID;
import wang.gnim.netty.server.core.spring.SpringContext;

public class TicketIDDAO extends SqlSessionDaoSupport {

	private static final String NAMESPACE = TicketIDDAO.class.getCanonicalName();

	// 单例
	private static TicketIDDAO INSTANCE = null;

	public static TicketIDDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = (TicketIDDAO) SpringContext.INSTANCE.getApplicationContext()
					.getBean("ticketIDDAO", TicketIDDAO.class);
		}

		return INSTANCE;
	}
	
	public void get64ID(TicketID tid) {
		getSqlSession().insert(NAMESPACE + ".get64ID", tid);
	}
	
}
