package wang.gnim.netty.server.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import wang.gnim.netty.server.dao.jdbc.DataBase;

public class TestDataBase {

	@Test
	public void test_() {
		ResultSet result = DataBase.INSTANCE.query("select * from test");
		try {
			if(result.next())
				Assert.assertEquals(1, result.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
