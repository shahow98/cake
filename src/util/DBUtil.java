package util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DBUtil {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/cake?useUnicode=true&characterEncoding=UTF-8";
	private String username = "root";
	private String password = "root";
	private Connection conn = null;
	private static DBUtil instance = null;

	public static synchronized DBUtil getInstance() {
		if (instance == null) {
			instance = new DBUtil();
		}
		return instance;
	}

	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url, username, password);
			System.out.println("success connection");
		} catch (ClassNotFoundException e) {
			System.out.println("fail connection");
			return null;
		} catch (SQLException e) {
			System.out.println("fail connection");
			return null;
		}
		return conn;
	}

	public void close(Connection conn, PreparedStatement pstm, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("fail close");
		}
	}

	// test
	public static void main(String[] args) {
		DBUtil db = DBUtil.getInstance();
		Connection connection = db.getConnection();
		db.close(connection, null, null);

	}

}
