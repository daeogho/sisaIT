package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LbMysqlDBConnection {

	static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); // mysql connector 경로 어딘지 서식)
			}catch (ClassNotFoundException cnfe) {				
			}
		}

	protected Connection conn = null;
	protected String sql = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;

	private String url = "jdbc:mysql://192.168.4.103:3306/library";
	private String username = "kdh";
	private String password = "0223";

	public LbMysqlDBConnection() {
	}

	public void mysqlConnect() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("DB연걸 예외 발생 :" + e.getMessage());
		}
	}
	// 연결 끊기
	public void dbClose() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch (Exception e) {			
		}
	}

}
