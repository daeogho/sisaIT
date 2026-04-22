package j05Inheritance;

import java.io.File;

// 클래스가 final이면 상속불가
public class StringInheritance extends AAA{
	public StringInheritance() {
		output();
	}
	//메소드의 final은 오버라이딩 할 수 없다.
	//@Override
	//public void output() {
	//	System.out.println("하위 클래스에서 상위클래스 오버라이딩....");
	//}
	
	
	public static void main(String[] args) {
		new StringInheritance();

	}

}
