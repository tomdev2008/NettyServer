package wang.gnim.netty.server.common;

import java.util.concurrent.atomic.AtomicLong;

import wang.gnim.netty.server.dao.jdbc.IDQuery;

/**
 * ID最后四位作为服务器标识符, 即便如此ID的最大值也达到了1M(Long最大值去掉最后四位)
 * 
 * @author wangming
 *
 */
public enum IDFactory {

	test("test");
	
	private AtomicLong id;
	
	/**
	 * 找到数据库里最大的值,作为初始ID
	 * 
	 * @param tableName 数据库表名
	 */
	IDFactory(String tableName) {
		int dbID = IDQuery.queryMaxID(tableName);
		if(dbID == 0)
			id = new AtomicLong(tail);
		else 
			id = new AtomicLong(dbID);
	}
	
	private final long increasevalue = 10000;
	private final long tail = increasevalue + ServerProperties.SERVER_ID.intValue();
	
	public long increase() {
		return id.addAndGet(increasevalue);
	}
	
	public long get() {
		return id.longValue();
	}
}
