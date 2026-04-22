package j13JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MemberInsert {
	// 1. JDBC드라이브를 JVM에 위치를 알려준다. -------------------------------------------------------------
	
	static {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("드라이브 로딩 예외발생...." + cnfe.getMessage());
		}
	} // 35
	Scanner scan = new Scanner(System.in);
	public MemberInsert() {
		// 회원등록 : member테이블에 회원추가
	}

	public void start() {
		// 콘솔에 회원정보를 입력받아 DB에 insert하기
		try {
			// 회원정보 입력
			System.out.print("회원명=");
			String name = scan.nextLine();
			System.out.print("연락처=");
			String tel = scan.nextLine();
			System.out.print("이메일=");
			String email = scan.nextLine();
			System.out.print("성별(남/여)=");
			String gender = scan.nextLine();
			System.out.print("생년월일(2001-12-12)=");
			String birth = scan.nextLine();
			
			// 2. DB연결 -------------------------------------------------------------------------------------------------------
			
			// DriverManager를 데이터베이스가 있는 위치, 포트, 계정, 비밀번호
			// 서버주소, 포트번호, DB명 계정 비밀번호
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/study_db", "root", "tiger1234");
			
			// 3. 쿼리를 이용하여 PreparedStatement 객체생성 -------------------------------------------------------------------------
			
			// 이름, 연락처, 이메일, 성별, 생년월일
			String sql = "insert into member(name, tel, email, gender, birthdate) values(?,?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			// setInt(), setString(), setDouble(), setBoolean()
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			pstmt.setString(3, email);
			pstmt.setString(4, gender);
			pstmt.setString(5, birth);
			
			// 4. 쿼리문 실행 -----------------------------------------------------------------------------------------------------
			// 0 : 등록실패, 1 : 등록
			int result = pstmt.executeUpdate();
			
			if(result ==1) {
				System.out.println("등록성공...");
			}else {
				System.out.println("등록실패...");
			}
			
			
			// 5. 연결끊기 --------------------------------------------------------------------------------------------------------
			pstmt.close();
			con.close();
			
			
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new MemberInsert().start();

	}

}
