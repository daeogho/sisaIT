package J01_basic;

import java.util.Scanner;

public class J32ReferenceType {

	public static void main(String[] args) {
		// 기본데이터 타입, 레퍼런스 타입의 메모리 사용방법
		
		int num = 100;
		int price = 100;
		
		String name = "홍길동";
		String firstName = "홍길동";
		
		String a = new String("세종대왕");
		String b = new String("세종대왕");
		
		Scanner scan = new Scanner(System.in);
		
		if(num == price) {
			System.out.println("num과 price의 값은 같다.");
		}else{
			System.out.println("num과 price의 값은 같지 않다.");
			
		} // String은 특수 클래스이기 때문에 기본데이터타입과 같은 기능을 제공한다.
		if(name == firstName) {
			System.out.println("name과 firstName의 값은 같다.");
	}else {
			System.out.println("name과 firstName의 값은 같지 않다.");
	}
		//
		if(a == b) {
			System.out.println("a과 b의 값은 같다.");
		}else {
			System.out.println("a과 b의 값은 다르다.");
			
		}
		//레퍼런스변수는 == 데이터가 있는 주소를 비교
		// 주소가 아닌 실제 객체 내용을 가지고 비교하기위해서는 equals()메소드를 이용하여 같은 지 확인한다.
		if( a.equals(b) ) { //b.equals(a) 순서는 상관이 없다.
			System.out.println("equlas() -> a과 b의 값은 같다.");
		}else {
			System.out.println("equlas() -> a과 b의 값은 다르다.");
			
		}
		
		String compony = new String("시사IT아카데미");
		String compony2 = compony;
		
		if(compony == compony2) {
			System.out.println("compony와 compony2는 같다.");
		}else {
			System.out.println("compony와 compony2는 다르다.");
		}
		
	}

}
