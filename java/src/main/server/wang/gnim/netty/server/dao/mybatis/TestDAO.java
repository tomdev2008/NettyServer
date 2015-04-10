package wang.gnim.netty.server.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import wang.gnim.netty.server.bean.Test;
import wang.gnim.netty.server.core.spring.SpringContext;

/**
 * 通过mybatis执行到dao操作
 * @author Administrator
 *
 */
public class TestDAO  extends SqlSessionDaoSupport {

	private static final String NAMESPACE = TestDAO.class.getCanonicalName();

	// 单例
	private static TestDAO INSTANCE = null;

	public static TestDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = (TestDAO) SpringContext.INSTANCE.getApplicationContext()
					.getBean("testDAO", TestDAO.class);
		}

		return INSTANCE;
	}
	
	public List<Test> select() {
		return getSqlSession().selectList(NAMESPACE + ".selectAll");
	}
	
}
