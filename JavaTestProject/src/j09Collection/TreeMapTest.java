package j09Collection;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public TreeMapTest() {

	}
	public void start() {
		// TreeMap은 key와 value가지면, key를 기준으로 정렬한다.
		TreeMap<String, MemberDTO> tm = new TreeMap<String, MemberDTO>();
		
		tm.put("홍길동", new MemberDTO(1, "홍길동", "010-1111-2222"));
		tm.put("세종대왕", new MemberDTO(2, "세종대왕", "010-2222-2222", "king@nate.com", "서울시 종로구"));
		tm.put("안중근", new MemberDTO(3, "안중근", "010-9999-8888", "jung@naver.com", "서울시 영등포구"));
		tm.put("이순신", new MemberDTO(4, "이순신","010-5555-6666","sunsin@gmail.com","서울시 강남구"));
		tm.put("운동주", new MemberDTO(5, "윤동주", "010-8989-8989"));
		
		Set<String> key = tm.keySet();
		Iterator<String> ii = key.iterator();
		while(ii.hasNext()) {
			String k = ii.next();
			MemberDTO member = tm.get(k);
			System.out.println(member.toString());
			
		}
	}

	public static void main(String[] args) {
		new TreeMapTest().start();

	}

}
