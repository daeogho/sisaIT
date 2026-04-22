package j13JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlDBConnection {

	static {
		try {
			Class.forName("com.mysql.ch.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
		}
	}
	// 변수
	protected Connection conn = null;
	protected String sql = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;

	private String url = "jdbc:mysql://127.0.0.1:3306/study_db";
	private String username = "root";
	private String password = "tiger1234";

	public MysqlDBConnection() {
	}

	// DB연결
	public void mysqlConnect() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("DB연결 예외 발생..." + e.getMessage());
		}
	}

	// DB연결끊기
	public void dbClose() {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
		}
	}

}
