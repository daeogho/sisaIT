package j09Collection;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ArrayListTest {

	public ArrayListTest() {
		
	}
	public ArrayList getAllData() {
		// 모든 메소드는 반환형이 없거나 아니면 1개만 리턴이 가능하다.
		// 데이터타입이 같으면 배열을 이용하여 하나로 만들어 리턴이 가능하다.
		// 데이터형이 다르면 배열을 이용할 수 없다.
		// 데이터타입, 갯수가 유동적이라도 1개의 객체로 담을 수 있는 클래스들을 컬렉션이라고 한다.
		// List, Set, Map으로 구별된다.
		// List 인터페이스를 상속받은 클래스 데이터추가 순서를 유지하고 중복데이터를 허용한다.
		
		int num = 500;
		String name = "이순신";
		Calendar date = Calendar.getInstance(); // 2025 - 11 -20 12:__
		date.set(Calendar.YEAR, 2027);
		
		// 1명 : 번호, 이름, 연락처, 이메일, 주소
		MemberDTO mem = new MemberDTO();
		mem.setNum(1);
		mem.setName("홍길동");
		mem.setTel("010-7777-8888");
		mem.setEmail("hong@naver.com");
		mem.setAddr("서울시 종로구");
		
		MemberDTO mem2 = new MemberDTO(2, "세종대왕", "010-1234-5678", "king@korea.com", "서울시 종로구");
		
		ArrayList al = new ArrayList();
		// List al2 = new ArrayList();
		al.add(num); //0
		al.add(name); //2
		al.add(date); //3
		al.add(mem); //4 
		al.add(1, mem2); //1
		
		return al;
		
	}
	// 회원목록
	public List allMember() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		list.add(new MemberDTO(100, "김길동","010-1234-5555","kim@nate.com","영등포구"));
		list.add(new MemberDTO(200, "이길동","010-7878-9999","lee@naver.com","강남구"));
		list.add(new MemberDTO(300, "박길동","010-5656-8989","park@daum.net","송파구"));
		list.add(new MemberDTO(400, "최길동","010-1122-5656","chio@gmail.com","관악구"));
		list.add(new MemberDTO(500, "강길동","010-1515-4545","gang@korea.com","강서구"));
		
		return list;
	}

}
