package wang.gnim.netty.server.common;

import wang.gnim.netty.server.bean.TicketID;
import wang.gnim.netty.server.dao.mybatis.TicketIDDAO;

/**
 * 仿照Flick Ticket Server实现
 * 不同的枚举代表着不同的表, 这样一来, 在拓充的时候, 只需要拓充枚举就好了
 * 
 * @author wangming
 *
 */
public enum TicketIDFactory {

	A("a"),
	B("b"),
	K("k");
	
	TicketIDFactory(String table) {
		this.table = table;
	}
	
	private String table;
	
	public long get64ID() {
		TicketID tid = new TicketID();
		tid.setStub(table);
		synchronized (tid) {
			TicketIDDAO.getInstance().get64ID(tid);
		}
		
		return tid.getId();
	}
}
