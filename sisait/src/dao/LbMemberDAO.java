package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.LbMemberDTO;
import lib.LbMysqlDBConnection;

public class LbMemberDAO extends LbMysqlDBConnection {

	public LbMemberDAO() {
	}
	public List<LbMemberDTO> bookAll(){ // 도서전체 선택
		try {
			mysqlConnect();
			
			sql = "select book_code, book_name, book_author, book_publication, book_date, book_loc "
					+ "from book_tbl";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
					
					return setResultSet(rs);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return null;
	}

	public List<LbMemberDTO> bookSearch(String book_name) { // 도서명검색

		try {
			mysqlConnect();

			sql = "select book_code, book_name, book_author, book_publication, book_date, book_loc "
					+ "from book_tbl where book_name like ? order by book_name asc";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + book_name + "%");

			rs = pstmt.executeQuery();

			return setResultSet(rs);

		} catch (Exception e) {
			System.out.println("도서명 검색 중 예외발생함 : " + e.getMessage());
		} finally {
			dbClose();
		}
		return null;
	}
	public List<LbMemberDTO> authorSearch(String book_author) { // 도서 저자명 검색

		try {
			mysqlConnect();

			sql = "select book_code, book_name, book_author, book_publication, book_date, book_loc "
					+ "from book_tbl where book_author like ? order by book_name asc";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + book_author + "%");

			rs = pstmt.executeQuery();

			return setResultSet(rs);

		} catch (Exception e) {
			System.out.println("저자명 검색 중 예외발생함 : " + e.getMessage());
		} finally {
			dbClose();
		}
		return null;
	}

	public int bookAdd(LbMemberDTO dto) { // 도서추가
		int result = 0;
		try {
			mysqlConnect();
			sql = "insert into book_tbl(book_code, book_name, book_author, book_publication, book_date, book_loc) "
					+ "values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dto.getBook_code());
			pstmt.setString(2, dto.getBook_name());
			pstmt.setString(3, dto.getBook_author());
			pstmt.setString(4, dto.getBook_publication());
			pstmt.setString(5, dto.getBook_date());
			pstmt.setString(6, dto.getBook_loc());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.print("도서등록 예외발생 =" + e.getMessage());
		} finally {
			dbClose();
		}
		return result;
	}

	public int bookDel(int book_code) { // 도서삭제

		int result = 0;
		try {
			mysqlConnect();

			sql = "delete from book_tbl where book_code=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book_code);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("도서 삭제 예외 발생 = " + e.getMessage());
		} finally {
			dbClose();
		}
		return result;
	}
	
	public int bookUpadte(int il, String witch) {  // 도서위치 수정
		int result = 0;
		
		try {
			mysqlConnect();
			
			sql = "update book_tbl set book_loc=? where book_code =?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, witch);
			pstmt.setInt(2, il);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("도서위치 수정중 예외 발생 : " + e.getMessage());
		}finally {
			dbClose();
		}
		return result;
	}

	public List<LbMemberDTO> setResultSet(ResultSet rs) {
		ArrayList<LbMemberDTO> member = new ArrayList<LbMemberDTO>();
		try {
			while (rs.next()) {

				LbMemberDTO dto = new LbMemberDTO();
				dto.setBook_code(rs.getInt(1));
				dto.setBook_name(rs.getString(2));
				dto.setBook_author(rs.getString(3));
				dto.setBook_publication(rs.getString(4));
				dto.setBook_date(rs.getString(5));
				dto.setBook_loc(rs.getString(6));

				member.add(dto);
			}
		} catch (Exception e) {
		}
		return member;

	}

}
