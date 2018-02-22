package study.queryobject;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	private static Connection conn;

	public static void init() throws SQLException, ClassNotFoundException {
		//Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		//conn = DriverManager.getConnection("jdbc:derby:memory:test;create=true", "admin", "admin");
		conn = DriverManager.getConnection("jdbc:derby://localhost:1527/E:/javaDB/talend/test;create=true", "admin", "admin");
	}

	public static Statement createStatement() throws SQLException {
		return conn.createStatement();
	}

	public static PreparedStatement prepareStatement(String sql) throws SQLException {
		return conn.prepareStatement(sql);
	}
	
	public static DatabaseMetaData getMetaData() throws SQLException {
		return conn.getMetaData();
	}

	public static void terminate() throws Exception {
		if (conn == null) {
			return;
		}
		try {
			if (conn.isClosed() == false) {
				conn.close();
			}
		} catch (SQLException ignore) {
		}
	}

}
