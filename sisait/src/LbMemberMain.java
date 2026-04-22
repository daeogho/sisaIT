import java.util.List;
import java.util.Scanner;

import dao.LBUserDAO;
import dao.LbMemberDAO;
import dto.LbMemberDTO;
import dto.LbUserDTO;

public class LbMemberMain {

	Scanner scan = new Scanner(System.in);

	public LbMemberMain() {

	}

	public void Start() {

		System.out.println("사용자를 선택하세요.");
		System.out.println("--------------------------------------------------------");
		System.out.println("1.관리자모드, 2.회원가입 및 도서찾기");

		int user = Integer.parseInt(scan.nextLine());

		if (user == 1) {

			do {
				System.out.println("--------------------------------------------------------");
				System.out.println("1.회원관리, 2.도서관리, 3.종료");

				int manage = Integer.parseInt(scan.nextLine());

// ----------------------------------회원관리-----------------------------

				if (manage == 1) {
					System.out.println("--------------------------------------------------------");
					System.out.println("1.회원검색, 2.회원등록, 3.회원삭제, 4.회원수정, 5.종료");

					try {
						int usermenu = Integer.parseInt(scan.nextLine());

						switch (usermenu) {
						case 1:
							userSearch();
							break;
						case 2:
							userInsert();
							break;
						case 3:
							userDelete();
							break;
						case 4:
							userEdit();
							break;
						case 5:
							System.out.print("프로그램이 종료 되었습니다.");
							System.exit(0);
						default:
							System.out.println("메뉴를 잘 못 선택하였습니다.");
						}
					} catch (NumberFormatException nfe) {
						System.out.println("1~7번 사이의 숫자를 입력해주세요.");

					}
// -------------------------------------도서관리----------------------------------
				} else if (manage == 2) {
					System.out.println("--------------------------------------------------------");
					System.out.println("1. 도서검색, 2.도서등록, 3.도서삭제, 4.도서위치수정, 5. 종료");

					try {
						int bookmenu = Integer.parseInt(scan.nextLine());

						switch (bookmenu) {
						case 1:
							bookSearch();
							break;
						case 2:
							bookInsert();
							break;
						case 3:
							bookDel();
							break;
						case 4:
							bookEdit();
							break;
						case 5:
							System.out.print("종료되었습니다.");
							System.exit(0);
						default:
							System.out.println("메뉴를 잘 못 선택하였습니다");
						}
					} catch (NumberFormatException nfe) {
						System.out.println("1~5번 사이의 숫자를 입력해주세요.");
					}
				} else if (manage == 3) {
					System.out.println("종료되었습니다.");
					System.exit(0);
				} else {
					System.out.println("1 또는 2 숫자를 입력해주세요.");
				}
			} while (true);
		}

// --------------------------------------------- 도서찾기 프로그램 -------------------------------------------------------

		else if (user == 2) {

			do {

				System.out.print("1.회원등록, 2.도서명 검색하기, 3.저자명 검색하기\n");
				System.out.println("--------------------------------------------------------");
				try {
					int menu = Integer.parseInt(scan.nextLine());

					switch (menu) {
					case 1:
						userInsert();
						break;
					case 2:
						bookSearch();
						break;
					case 3:
						bookSearch2();
						break;
					default:
						System.out.println("번호를 잘못 누르셨습니다.");
					}
				} catch (NumberFormatException nfe) {
					System.out.println("1~5번까지의 번호를 입력해 주세요.");
				}

			} while (true);

		}

	}

	// ---------------------------------------User_tbl---------------------------
	// 전체 유저 선택
	public void userAll() {
		LBUserDAO userdao = new LBUserDAO();
		List<LbUserDTO> userlist = userdao.userAll();

		for (LbUserDTO userdto : userlist) {
			System.out.println(userdto.toString());
		}
	}

	// 유저 검색
	public void userSearch() {
		userAll();
		System.out.println("--------------------------------------------------------");
		System.out.println("검색할 회원의 이름을 입력하세요 :");

		String username = scan.nextLine();

		LBUserDAO userdao = new LBUserDAO();
		List<LbUserDTO> userlist = userdao.LbuserSearch(username);

		for (LbUserDTO userdto : userlist) {
			System.out.println(userdto.toString());
		}
	}

	// 유저 등록
	public void userInsert() {

		LbUserDTO userdto = new LbUserDTO();

		System.out.print("ID : ");
		userdto.setUser_id(scan.nextLine());
		System.out.print("PW : ");
		userdto.setUser_pw(scan.nextLine());
		System.out.print("이름 : ");
		userdto.setUser_name(scan.nextLine());
		System.out.print("연락처 : ");
		userdto.setUser_tel(scan.nextLine());
		System.out.print("생년월일 : ");
		userdto.setUser_birth(scan.nextLine());

		LBUserDAO userdao = new LBUserDAO();
		int result = userdao.userAdd(userdto);

		if (result == 1) {
			System.out.print("회원등록이 완료되었습니다.\n");
		} else {
			System.out.print("회원등록에 실패하였습니다.\n");
		}

	}

	// 유저 삭제
	public void userDelete() {
		userAll();
		System.out.println("--------------------------------------------------------");
		System.out.println("삭제할 회원의 ID를 입력하세요.");

		String user_id = scan.nextLine();

		LBUserDAO userdao = new LBUserDAO();
		int result = userdao.userDel(user_id);

		if (result >0) {
			System.out.println("회원" + user_id + "님이 삭제되었습니다.");
		} else {
			System.out.println("입력하신 ID가 잘 못 되었습니다.");
		}

	}

	// 유저 수정
	public void userEdit() {
		userAll();
		System.out.println("--------------------------------------------------------");
		System.out.print("수정할 회원의 ID를 입력하세요.");

		String userid = scan.nextLine();

		System.out.print("수정할 연락처를 입력하세요.");
		String usertel = scan.nextLine();

		LBUserDAO userdao = new LBUserDAO();
		int result = userdao.userUpdate(usertel, userid);
		
		if(result >0) {
		System.out.println("회원" + userid + "님의 연락처가" + usertel + "로 변경되었습니다.");
		System.out.println("--------------------------------------------------------");
		}else {
			System.out.println("입력한 " + userid + "는 없는 회원 입니다.");
		}
	}

	// ----------------------------------book_tbl----------------------
	// 전체 도서검색
	public void bookAllSelect() {
		LbMemberDAO dao = new LbMemberDAO();
		List<LbMemberDTO> list = dao.bookAll();

		for (LbMemberDTO dto : list) {
			System.out.println(dto.toString());
		}

	}

	// 도서찾기 (도서명으로 찾기)
	public void bookSearch() {

		bookAllSelect();
		System.out.println("--------------------------------------------------------");
		System.out.println("검색할 도서의 이름을 입력하세요 : ");

		String name = scan.nextLine();

		LbMemberDAO dao = new LbMemberDAO();
		List<LbMemberDTO> list = dao.bookSearch(name);

		for (LbMemberDTO dto : list) {
			System.out.println(dto.toString());
		}
	}

	// 도서찾기 (저자명으로 찾기)
	public void bookSearch2() {

		bookAllSelect();
		System.out.println("--------------------------------------------------------");
		System.out.println("검색할 도서저자의 이름을 입력하세요 : ");

		String name = scan.nextLine();

		LbMemberDAO dao = new LbMemberDAO();
		List<LbMemberDTO> list = dao.authorSearch(name);

		for (LbMemberDTO dto : list) {
			System.out.println(dto.toString());
		}
	}

	// 도서등록
	public void bookInsert() {

		LbMemberDTO dto = new LbMemberDTO();

		System.out.print("도서 일련번호 =");
		dto.setBook_code(Integer.parseInt(scan.nextLine()));

		System.out.print("도서명 =");
		dto.setBook_name(scan.nextLine());

		System.out.print("도서 저자 =");
		dto.setBook_author(scan.nextLine());

		System.out.print("출판사 =");
		dto.setBook_publication(scan.nextLine());

		System.out.print("도서 출판년도 =");
		dto.setBook_date(scan.nextLine());

		System.out.print("도서 위치 =");
		dto.setBook_loc(scan.nextLine());

		LbMemberDAO dao = new LbMemberDAO();
		int result = dao.bookAdd(dto);

		if (result == 1) {
			System.out.println("도서등록이 완료되었습니다.");
		} else {
			System.out.println("도서등록에 실패하였습니다.");
		}

	}

	// 도서삭제
	public void bookDel() {

		bookAllSelect();
		System.out.println("삭제할 도서의 일련번호를 입력하세요.");
		System.out.println("--------------------------------------------------------");
		int book_code = Integer.parseInt(scan.nextLine());

		LbMemberDAO dao = new LbMemberDAO();
		int result = dao.bookDel(book_code);

		if (result > 0) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("삭제하는데 실패 하였습니다.");
		}
	}

	// 도서 수정
	public void bookEdit() {

		bookAllSelect();
		System.out.print("위치를 변경할 도서의 일련번호를 입력하세요.");
		System.out.println("--------------------------------------------------------");
		int il = Integer.parseInt(scan.nextLine());

		System.out.print("변경할 위치를 입력하세요.");
		String witch = scan.nextLine();

		LbMemberDAO dao = new LbMemberDAO();
		int result = dao.bookUpadte(il, witch);

		if (result > 0) {
			System.out.println("일련번호 " + il + "의 위치가 수정되었습니다.");
		} else {
			System.out.println("수정 실패하였습니다.");
		}
	}

	public static void main(String[] args) {
		new LbMemberMain().Start();
	}

}
