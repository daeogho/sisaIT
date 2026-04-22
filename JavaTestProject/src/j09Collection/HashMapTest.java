package j09Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest {

	public HashMapTest() {
		// HashMap은 key와 value를 가지는 자료구조이다.
		// key는 중복해서 사용할 수 없다.
		
		HashMap<String, MemberDTO> hm = new HashMap<String, MemberDTO>();
		
		//HashMap에 객체를 추가할 때는 put(key, value)		
		hm.put("홍길동", new MemberDTO(1, "홍길동", "010-1111-2222"));
		hm.put("세종대왕", new MemberDTO(2, "세종대왕", "010-2222-2222", "king@nate.com", "서울시 종로구"));
		hm.put("안중근", new MemberDTO(3, "안중근", "010-9999-8888", "jung@naver.com", "서울시 영등포구"));
		hm.put("이순신", new MemberDTO(4, "이순신","010-5555-6666","sunsin@gmail.com","서울시 강남구"));
		hm.put("운동주", new MemberDTO(5, "윤동주", "010-8989-8989"));
		
		// 1개의 객체만 얻어올때
		MemberDTO dto = hm.get("세종대왕");
		System.out.println(dto.toString());
		
		// key값 전체를 Set으로 구하기
		Set<String> keyList = hm.keySet();
		Iterator<String> ii = keyList.iterator();
		
		while(ii.hasNext()) {
			String k = ii.next();
			MemberDTO m = hm.get(k);
			System.out.println(m.toString());
			
		}
		
	}

	public static void main(String[] args) {
		new HashMapTest();

	}

}
