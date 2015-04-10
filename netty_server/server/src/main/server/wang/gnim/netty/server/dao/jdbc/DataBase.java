package wang.gnim.netty.server.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import wang.gnim.netty.server.common.ServerProperties;

public enum DataBase {
	
	INSTANCE;
	
	/** 定义一个Connection 用来连接数据库 */
	private Connection conn = null;
	/** 连接数据库的URL */
	private final String url = ServerProperties.MYSQL_URL.value;
	/** 指定数据的用户名和密码 */
	private final String username = "root";
	private final String password = "root";
	int count = 0;
	/** 定义一个结果集 用于放回查询结果 */
	private ResultSet resultSet = null;
	private PreparedStatement pstmt = null;

	DataBase() {
		connectionDB();
	}

	/**
	 * 建立数据的连接
	 * 
	 * @exception SQLException
	 *                , ClassNotFoundException
	 */
	private void connectionDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("建立数据库发生错误！");
		} finally {
		}
	}

	/**
	 * 查询方法
	 * 
	 * @param sql查询sql语句
	 * @return resultSet
	 */
	public ResultSet query(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
			/** 查询 */
			resultSet = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return resultSet;
	}

	/**
	 * 更新数据
	 * 
	 * @param sql
	 *            更新sql语句
	 * @return
	 */
	public int update(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("执行更新出错了");
		}

		return count;
	}

	/** 关闭连接 */
	public boolean coles() {
		boolean isColes = false;
		if (resultSet != null) {
			try {
				resultSet.close();
				resultSet = null;
				isColes = true;
			} catch (SQLException e) {
				isColes = false;
				e.printStackTrace();
				System.out.println("关闭结果集发生错误");
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
				pstmt = null;
				isColes = true;
			} catch (SQLException e) {
				isColes = false;
				e.printStackTrace();
				System.out.println("关闭pstmt发生异常");
			}
		}
		if (conn != null) {
			try {
				conn.close();
				conn = null;
				isColes = true;
			} catch (Exception e) {
				isColes = false;
				e.printStackTrace();
				System.out.println("关闭conn发生异常");
			}
		}
		return isColes;
	}


}
