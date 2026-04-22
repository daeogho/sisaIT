package j09Collection;

import java.util.HashSet;
import java.util.Iterator;

import javax.imageio.stream.IIOByteBuffer;

public class HashSetTest {

	public HashSetTest() {
		// Set 인터페이스 상속받은 HashSet클래스는 저장 순서 유지 하지 않는다.
		// 중복을 허용하지 않는다.
		int data[] = {52, 45, 84, 24, 24, 24, 26, 56, 89, 52, 53};
		
		HashSet<Integer> hs = new HashSet<Integer>();
		
		for(int d : data) {
			hs.add(d);
		}
		
		// HashSet 객체는 담겨 있는 객체를 꺼내기 위해서 Iterator를 구하여야 한다.
		Iterator<Integer> ii = hs.iterator();
		while(ii.hasNext()) {
			Integer n = ii.next();
			System.out.println(n);
		}
		System.out.println("=======================");
//--------------------------------------------------------------------------------------------
		
		String names[] = {"손흥민","박지성","안정환","김민재","박지성","손흥민","안정환","이강인","김민재"};
		
		HashSet<String> hs2 = new HashSet<String>();
		for(String name : names) {
			hs2.add(name);
		}
		
		Iterator<String> iii = hs2.iterator();
		while(iii.hasNext()){
			String name = iii.next();
			System.out.println(name);
		}
		
	}

	public static void main(String[] args) {
		HashSetTest hst = new HashSetTest();

	}

}
