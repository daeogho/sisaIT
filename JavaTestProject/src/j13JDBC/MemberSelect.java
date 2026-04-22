package j13JDBC;

public class MemberSelect extends MysqlDBConnection {

	public MemberSelect() {

	}

	public void memberStart() {
		try {
			// 2. DB연결
			mysqlConnect();
			// 3. 쿼리문
			sql = "select m_no, name, tel, email, gender, birthdate,"
					+ " date_format(writedate, '%m-%d %H:%i')writedate" + " from member order by m_no";
			// 행 변경시 글자가 이어지기 때문에 한칸 띄어 줄것 (ex: writedate 처럼)

			pstmt = conn.prepareStatement(sql);

			// 4. 실행
			rs = pstmt.executeQuery(); // MysqlDBConnection에 상속했기에 변수만 사용

			// rs객체에 있는 레코드 접오 얻어오기
			while (rs.next()) {
				int m_no = rs.getInt("m_no"); // rs.getInt(1);와 같다
				String name = rs.getString(2);
				String tel = rs.getString(3);
				String email = rs.getString(4);
				String gender = rs.getString(5);
				String birthdate = rs.getString(6);
				String writedate = rs.getString(7); // 2025-12-02 10 : 10 :10 (년월일초 다나옴)

				System.out.printf("%4d %10s %15s %30s %5s %15s %20s\n", m_no, name, tel, email, gender, birthdate,
						writedate);
			}

		} catch (Exception e) {
			System.out.println("예외 발생함...." + e.getMessage());
		} finally {
			// DB닫기
			dbClose();
		}

	}

	// 이름으로 회원목록 선택하기
	public void nameSearch(String name) {
		try {
			mysqlConnect();

			sql = "select m_no, name, tel from member " + "where name like ?";
			// where name like '%이름%'

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");

			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					int m_no = rs.getInt(1);
					String username = rs.getString(2);
					String tel = rs.getString(3);
					System.out.println(m_no + "\t" + username + "\t" + tel);
				} while (rs.next());
			} else {
				System.out.println(name + "과 일치하는 회원이 없습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

	}

//	public static void main(String[] args) {
//		new MemberSelect().memberStart();
//
//	}

}
