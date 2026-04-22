package j05Inheritance;

import java.util.Calendar;

import j04oop.ZZZZ;

public class ProtectedTest extends ZZZZ{
	
	public ProtectedTest() {
		System.out.println("firstName=" + firstName);
		System.out.println("성 = " + getFirstName());
		
		// 생성자메소드에 protected 객체생성할 수 없다.
		// ZZZZ z = new ZZZZ();
		// 다른 팩키지의 변수가 protected 접근제한자이면 상속받아 사용해야한다.
		// 같은 팩키지에서는 사용가능하다.
		// System.out.println(z.firstName);
		// default접근제한자이므로 다른 팩키지에서 접근할 수 없다.
		// System.out.println(z.lastName);
		// protected 메소드는 상속을 받아야 호출할 수 있다.
		// System.out.println(z.getFirstName());
		
		Calendar.getInstance(); // new Calendar() x
	}
	public static void main(String[] args) {
		new ProtectedTest();
	}

}
