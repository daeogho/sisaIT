package j13JDBC;

import java.util.Scanner;

public class MemberDelete extends MysqlDBConnection {
	Scanner scan = new Scanner(System.in);

	public MemberDelete() {

	}

	public void deleteStart() {
		try {
			MemberSelect ms = new MemberSelect();
			//ms.memberStart();
			
			// 회원명을 조회를 리스트 출력
			// 입력받아 데이터베이스의 회원을 삭제한다.
			System.out.print("회원명 입력 = ");
			String name = scan.nextLine();			
			ms.nameSearch(name);
			
			System.out.print("삭제할 회원번호를 입력=");
			int no = Integer.parseInt(scan.nextLine());
			
			mysqlConnect();
			
			sql = "delete from member where m_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			int result = pstmt.executeUpdate();
			
			if(result >0) {
				System.out.print("회원정보가 삭제되었습니다.");
			}else {
				System.out.println("회원정보 삭제");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

	}

	public static void main(String[] args) {
		new MemberDelete().deleteStart();

	}

}
