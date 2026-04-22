package j13JDBC;

import java.util.Scanner;

public class MemberUpdate extends MysqlDBConnection {
	Scanner scan = new Scanner(System.in);
	String title[] = {"연락처", "이메일"};
	public MemberUpdate() {
		
	}
	public void updateStart() {
		try {
			MemberSelect ms = new MemberSelect();
			ms.memberStart();
			System.out.println("-------------------------------------------");
			
			System.out.print("수정할 회원의 회원번호를 입력하세요.");
			int no = Integer.parseInt(scan.nextLine()); // 1,2,3,4
			
			// 전화번호, 이메일만 수정가능
			System.out.print("수정할 항목을 선택하세요.(1. 연락처, 2. 이메일)=>");
			int editField = Integer.parseInt(scan.nextLine());
			
			System.out.print("수정할 " + title[editField-1]+ "를 입력하세요=>");
			String editData = scan.nextLine();
			
			// 1. -> update member set tel=? where m_no=?
			// 2. -> update member set email =? where m_no=?
			
			mysqlConnect(); //DB연결 
			
			sql = "update member set " ; // 쿼리문처럼 활용되기 위해 띄어쓰기 확인 필수
			if(editField==1) {
				sql += "tel";
			}else {
				sql += "email";
			}
			sql += "=? where m_no=?";
	
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,  editData);
			pstmt.setInt(2, no);
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("회원정보가 수정됨");
			}else {
				System.out.println("회원정보 수정 실패..");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}

	public static void main(String[] args) {
		new MemberUpdate().updateStart();

	}

}
