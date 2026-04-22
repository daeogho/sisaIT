package j09Collection;

import java.util.LinkedList;

public class LinkedListTest {

	public LinkedListTest() {
		// LinkedList 컬렉션 클래스는 List, Queㅕe, Deque를 상속받고 있는 interface이다.
		// List : 저장 순서유지, 중복데이터 허용
		// Queue : 한쪽에서 입력하고 다른쪽에서 출력하는 자료구조이다.
		// Deque : 양쪽에서 입력하고 양쪽에서 출력하는 자료구조이다.
		// Queue, Deque는 출력하면 컬렉션에서 객체가 지워진다.
		
		LinkedList<String> ll = new LinkedList<String>();
		// 객체추가
		ll.offer("사과"); // 마지막에 추가  0
		ll.offer("바나나"); // 1
		ll.offerLast("파인애플"); // 	2
		ll.addLast("귤"); // 3
		ll.add("망고"); // 
		ll.push("배"); // 처음에 추가
		ll.addFirst("용과"); // 처음에 추가
		
		ll.add(4, "오렌지");
		
		//꺼내기
		while(!ll.isEmpty()) { // 객체 있으면 false, 객체가 없으면 true
			// 객체를 꺼내서 출력한다.
			String data = ll.pop();
			System.out.println(data);	
		}
	}

	public static void main(String[] args) {
		new LinkedListTest();

	}

}
