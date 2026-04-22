package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.MemberDTO;
import lib.MysqlDBConnection;

public class MemberDAO extends MysqlDBConnection {

	public MemberDAO() {
	}

	// 회원선택
	public List<MemberDTO> memberAll() {
		try {
			mysqlConnect();

			sql = "select m_no, name, tel, email, gender, birthdate, writedate from member " + "order by m_no desc";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			return setResultSet(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return null;
	}

	// 회원검색
	public List<MemberDTO> telMemberSearch(String tel) {

		try {
			// 1. DB연결
			mysqlConnect();

			sql = "Select m_no, name, tel, email, gender, birthdate, writedate"
					+ " from member where tel like ? order by tel asc";
			// 2. prepareStatement 객체를 query문을 이용하여 생성한다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + tel + "%");

			// 3. 실행
			rs = pstmt.executeQuery();

			return setResultSet(rs);

		} catch (Exception e) {
			System.out.println("전화번호 검색중 예외발생함.." + e.getMessage());
		} finally {
			dbClose();
		}
		return null;

	}

	// 회원등록
	public int memberAdd(MemberDTO dto) {
		int result = 0;
		try {
			mysqlConnect();
			sql = "insert into member(name, tel, email, gender, birthdate) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTel());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getBirthdate());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("회원등록 예외발생...." + e.getMessage());
		} finally {
			dbClose();
		}
		return result;
	}

	// 회원수정 수정할 회원번호 수정할 항목 수정할 데이터
	public int memberUpdate(int editM_no, int editField, String data) {
		int result = 0;

		try {
			mysqlConnect();

			sql = "update member set ";
			if (editField == 1)
				sql += "tel";
			else if (editField == 2)
				sql += "email";
			sql += "=? where m_no=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, data);
			pstmt.setInt(2, editM_no);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("회원정보수정 예외 발생...." + e.getMessage());
		} finally {
			dbClose();
		}
		return result;
	}

	// 회원삭제
	public int memberDel(int m_no) {

		int result = 0;
		try {
			mysqlConnect();

			sql = "delete from member where m_no=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m_no);

			result = pstmt.executeUpdate(); // 커리문 실행수식

		} catch (Exception e) {
			System.out.println("회원정보 삭제 예외 발생...." + e.getMessage());
		} finally {
			dbClose();
		}
		return result;
	}
	// 총회원수

	public List<MemberDTO> setResultSet(ResultSet rs) {
		ArrayList<MemberDTO> member = new ArrayList<MemberDTO>();
		try {
			while (rs.next()) {
				// DTO -> List
				MemberDTO dto = new MemberDTO();
				dto.setM_no(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setTel(rs.getString(3));
				dto.setEmail(rs.getString(4));
				dto.setGender(rs.getString(5));
				dto.setBirthdate(rs.getString(6));
				dto.setWritedate(rs.getString(7));

				member.add(dto);
			}
		} catch (Exception e) {
		}
		return member;
	}

}
