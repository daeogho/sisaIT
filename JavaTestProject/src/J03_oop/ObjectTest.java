package J03_oop;

import java.util.Calendar;
import java.util.Scanner;

//import 문 : 현재클래스에서 다른 패키지에 있는 클래스를 사용시 클래스가 있는 팩키지와 클래스명을 반드시 기술해야 한다.
//           생략할때는 java.lang팩키지에 있는 클래스는 import를 생략할 수 있다.
//           import java.lang. 클래스를 추가하는 것은 컴파일러(javac.exe)가 자동으로 추가 해준다.

// public final class ObjectTest{}
// public : 접근 제한자.(생략가능) : 다른 팩키지에 있는 클래스의 접근 허용
// 생략(default) : 다른 팩키지에서는 접근불가, 같은 팩키지 내에서는 접근허용
public class ObjectTest {
	// 클래스 영역
	// 멤버 변수 (필드) = 전역 변수
	// 실행문 기술불가, System.out.println(); if, for, while, do~while, switch문 등
	// 변수를 선언하는 곳, 객체를 생성하는 곳
	int num; // 정수 : 0;, 실수:0.0, 논리형:false, 객체형:null, String:null
	int sum;
	String name = "홍길동";
	Scanner scan = new Scanner(System.in);
	Calendar now = Calendar.getInstance();
	
	//실행문 사용 불가
	//System.out.println("실행문 출력");
	int total = 100 + 200; // 허용됨
//	if(num<100) {
//		System.out.println("크다");
//	}
	// 생성자 메소드 : 1개 이상 기술가능
	// 생성자메소드를 만드는 규칙
	// 메소드명이 클래스명과 같아야 한다.
	// 반환형이 없다.

//---------------------------------------------------------------
	
	public ObjectTest() {
		// 실행문 기술 가능
		// 객체 생성 할때 1번 실행된다.
		name = "세종대왕";
		num = 250;		
	}
	// 생성자 메소드가 여러개 일때는 메개변수의 수나, 데이터형이 달라야 한다.
	public ObjectTest(int num) {
		// 지역변수와 멤버변수 이름이 같을 때 전역변수를 지정하기 위해 사용하는 keyword
		this.num = num;
		System.out.println("생성지메소드(int a) 실행됨");
	}	
	public ObjectTest(String name) {
		this.name = name;
	}		
	public ObjectTest(int num, String name) {
		this.num = num;
		this.name = name;
		System.out.println("ObjectTest(int num, String name) 생성지메소드 실행됨");
	}
	// 메소드 생성 nextInt(), get(), set()......
	// 메소드명은 소문자로 시작, 모든 메소드는 ()
	// 메소드 블럭내에 기능구현
	// 접근제한자 반환형
	// 반환형은 메소드를 실행 후 결과 값을 외부로 내보낼때 보내는 데이터의 데이터형을 표기한다.
	// 반환정보가 없다. void 매게변수 = arguments

	//-------------------------------------------------------
	public void add(int a, int b) {
		int hap = a + b;
		System.out.println(a + " + " + b + " = " + hap);		
	}
	
	//반환형이 있는 메소드
	public int minus(int n1, int n2) {
		int result = n1 - n2;		
		return result; // 반환할 데이터를 반드시 return 해줘야 한다.
	}
		
	
}

