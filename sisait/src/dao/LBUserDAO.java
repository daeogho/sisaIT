package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.LbUserDTO;
import lib.LbMysqlDBConnection;

public class LBUserDAO extends LbMysqlDBConnection {

	public LBUserDAO() {
	}
	// 전체 회원 조회
	public List<LbUserDTO> userAll(){
		try {
			mysqlConnect();
			
			sql = "select user_id, rpad(substring(user_pw, 1, ceil(char_length(user_pw)/2)), char_length(user_pw), '*'),"
					+ " user_name, user_tel, user_birth "
					+ "from user_tbl order by user_name desc";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			return setResultSet(rs);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return null;
		
	}
	// 회원검색
	public List<LbUserDTO> LbuserSearch(String user_name) { 
		try {
			mysqlConnect();

			sql = "select user_id, user_pw, "
					+ "user_name, user_tel, user_birth "
					+ "from user_tbl where user_name like ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + user_name + "%");
			
			rs = pstmt.executeQuery();
			
			return setResultSet(rs);

		} catch (Exception e) {
			System.out.print("저자명 검색에 실패 하였습니다 :" + e.getMessage());;
		} finally {
			dbClose();
		}
		return null;

	}

	// 회원등록
	public int userAdd(LbUserDTO dto) {
		int result = 0;
		try {
			mysqlConnect();

			sql = "insert into user_tbl(user_id, user_pw, user_name, user_tel, user_birth)" + " values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getUser_id());
			pstmt.setString(2, dto.getUser_pw());
			pstmt.setString(3, dto.getUser_name());
			pstmt.setString(4, dto.getUser_tel());
			pstmt.setString(5, dto.getUser_birth());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("회원등록 실패 : " + e.getMessage());
		} finally {
			dbClose();
		}
		return result;

	}

	// 회원삭제
	public int userDel(String user_id) { //

		int result = 0; 
		try {
			mysqlConnect();

			sql = "delete from user_tbl where user_id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);

			result = pstmt.executeUpdate(); // result 값이 main으로 가는것이라  입력하는 변수와 관계없이 int

		} catch (Exception e) {
			System.out.print("회원정보 삭제 실패... : " + e.getMessage());
		} finally {
			dbClose();
		}
		return result;
	}

	// 회원수정
	public int userUpdate(String user_tel, String user_id) {
		int result = 0;

		try {
			mysqlConnect();

			sql = "update user_tbl set user_tel = ? where user_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_tel);
			pstmt.setString(2, user_id);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("회원정보수정 예외 발생... : " + e.getMessage());
		} finally {
			dbClose();
		}
		return result;
	}
	
	// 총회원수
	public List<LbUserDTO> setResultSet(ResultSet rs){
		ArrayList<LbUserDTO> user = new ArrayList<LbUserDTO>();
		try {
			while (rs.next()) {
				LbUserDTO userdto = new LbUserDTO();
				userdto.setUser_id(rs.getString(1));
				userdto.setUser_pw(rs.getString(2));
				userdto.setUser_name(rs.getString(3));
				userdto.setUser_tel(rs.getString(4));
				userdto.setUser_birth(rs.getString(5));
				
				user.add(userdto);
			}
		}catch (Exception e) {
			
		}return user;
	}
}
