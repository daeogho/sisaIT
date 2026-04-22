import java.util.List;
import java.util.Scanner;

import dao.MemberDAO;
import dto.MemberDTO;

public class SisaMemberMain {

	Scanner scan = new Scanner(System.in);

	public SisaMemberMain() {

	}

	public void Start() {
		do {
			// 메뉴
			System.out.print("[메뉴] 1.회원목록, 2.회원검색 3.회원등록, 4.회원수정, 5.회원삭제, 6.종료");
			try {

				int menu = Integer.parseInt(scan.nextLine());

				switch (menu) {
				case 1:
					memberAllSelect();
					break;
				case 2:
					memberSearch();
					break;
				case 3:
					memberInsert();
					break;
				case 4:
					memberEdit();
					break;
				case 5:
					memberDelete();
					break;
				case 6:
					System.out.println("회원관리 프로그램이 종료되었습니다.");
					System.exit(0);
				default:
					System.out.println("메뉴를 잘못 선택하였습니다.");
				}
			} catch (NumberFormatException nfe) {
				System.out.println("메뉴를 잘못입력하였습니다. 메뉴는 1~6까지 입니다.");
			}

		} while (true);
	}

	// 전체 회원 선택
	public void memberAllSelect() {
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.memberAll();

		for (MemberDTO dto : list) {
			System.out.println(dto.toString());
		}

	}

	// 전화번호를 이용한 회원검색
	public void memberSearch() {
		// 검색할 전화번호 입력
		System.out.print("검색할 회원의 전화번호를 입력하세요. =>");
		String tel = scan.nextLine(); // 010-1234-5678 1254

		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.telMemberSearch(tel);

		for (MemberDTO dto : list) {
			System.out.println(dto.toString());
		}
	}

	// 회원등록
	public void memberInsert() {
		// 회원정보 입력
		MemberDTO dto = new MemberDTO();

		System.out.print("회원명=>");
		dto.setName(scan.nextLine());
		System.out.print("연락처 =>");
		dto.setTel(scan.nextLine());
		System.out.print("이메일 =>");
		dto.setEmail(scan.nextLine());
		System.out.print("성별 =>");
		dto.setGender(scan.nextLine());
		System.out.print("생년월일(2002/01/01) =>");
		dto.setBirthdate(scan.nextLine());

		MemberDAO dao = new MemberDAO();
		int result = dao.memberAdd(dto);

		if (result == 1) {
			System.out.println("회원등록이 완료되었습니다..");
		} else {
			System.out.println("회원등록을 하지 못하였습니다.");
		}
	}

	// 회원정보 수정
	public void memberEdit() {
		String title[] = { "연락처", "이메일" };

		memberAllSelect(); // 전체 회원목록 보여주기 (위에 사용했던거 그대로 사용)
		// 어떤회원을 수정할 것 인지
		System.out.print("수정할 회원의 번호를 입력하세요.");
		int editM_no = Integer.parseInt(scan.nextLine());
		// 어떤항목수정 (연락처, 이메일)
		System.out.print("수정할 항목을 선택하세요.(1.연락처, 2.이메일)=>");
		int editField = Integer.parseInt(scan.nextLine());
		// 수정할 값입력
		System.out.print("변경할 " + title[editField - 1] + "을 입력하세요.");
		String data = scan.nextLine();

		MemberDAO dao = new MemberDAO();
		int result = dao.memberUpdate(editM_no, editField, data);

		if (result > 0) {
			System.out.println(title[editField - 1] + "가 수정되었습니다.");
		} else {
			System.out.println("수정 실패하였습니다..");
		}

	}

	public void memberDelete() {

		memberSearch(); // 회원번호를 기준으로 삭제
		
		System.out.println("삭제할 회원의 번호를 입력하세요.");
		int m_no = Integer.parseInt(scan.nextLine());

		MemberDAO dao = new MemberDAO();
		int result = dao.memberDel(m_no);

		if (result > 0) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("삭제하는데 실패하였습니다..");
		}

	}

	public static void main(String[] args) {
		new SisaMemberMain().Start();

	}

}
