package wang.gnim.netty.server.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IDQuery {

	public static int queryMaxID(String tableName) {
		
		final String sql = "SELECT Max(id) FROM " + tableName;
		ResultSet result = DataBase.INSTANCE.query(sql);
		if(result == null) {
			throw new RuntimeException(tableName + " table not exist!!!");
		} else {
			try {
				if(result.next()) {
					return result.getInt(1);
				} else {
					throw new RuntimeException(tableName + " have no vales!!!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		throw new RuntimeException(tableName + " query id error!!!");
		
	}
}
