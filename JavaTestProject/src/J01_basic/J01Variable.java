//패키지명 반드시 있어야 한다.
package J01_basic;

//클래스 명 : 파일명(첫번째문자는 대문자, 합성어일때 각 단어의 첫번째 글자는 대문자, 특수문자를 사용하지 않는다.)
public class J01Variable {
// [] 대괄호 배열, {} 중괄호 범위, () 소괄호
// 메소드 : 실행문 -> 수식, 변수선언, 처리문	
// main() 메소드는 실행시 자바 가상머신이 자동실행한다. 컴파일은 되나 실행은 안된다.
	public static void main(String[] args) {
		// 변수 선언 방법

		// 국어점수 = kor, koreaJumsu(J대문자인 이유는 가독성)
		// 가격 = price, 키 = height
		// 국어점수 = kor_5, koreaJumsu_7, price7$ 숫자 기입가능, 특수문자 _,$외에 안됨

		// 예약어는 변수로 사용할 수 없다.
		// 정수 : byte, shrot, int, long
		// 데이터타입 변수
		short kor;
		int eng;
		byte math;

		int a, b, c;

		int d = 10, e = 5;

		byte x = 120;
		byte y = (byte) 130; // 130을 byte타입으로 형변환

		long z = 21548775;

		// 문자열 + 정수 = 문자열 ex) 10+20=30, "10" +20 =1020
		System.out.println("d=" + d);
		a = d + e + 100;
		d = 120;
		System.out.println("d+a+100=" + a);

		System.out.println("y=" + y);

		long data = 2543254256L;
		System.out.println("data=" + data);

		// -실수-------------------------------------------
		float t1 = (float) 12.3; // float t1 = 12.3f;
		float t1_1 = 12.3f;
		double t2 = 12.3;

		System.out.println("t1=" + t1 + "\nt1_1=" + t1_1 + "\tt2=" + t2);
		// \n = 줄바꿈, \t = tab키랑 같음 8칸 뛰우기

		// 논리형 : true, false
		boolean boo = true;
		System.out.println("boo=" + boo); // sysout

		// 문자 : 1개의 문자를 보관한다.
		char name = 'A'; // '2' , '한'
		System.out.println("name=" + name);
		// 문자열 : 1개이상의 문자를 보관하는 변수

		char result = (char) (name + 1);
		int result2 = name + 1;

		System.out.println("result=" + result);
		System.out.println("result2=" + result2);

		// 자바에서 문자열은 기본 데이터형에는 타입이 없으며 클래스를 이용하여 처리할 수 있다.
		String msg = "String클래스는 일반 데이터형처럼 " + "사용할 수 있는 특수 클래스이다.";

		System.out.println(msg);

		// ---------------형변환(Type Casting)--------------------
		// 묵시적 형변환 : 작은데이터타입의 값이 큰 데이터타입의 변수로 대입될 때는 자동으로 형변환된다.
		int aa = 500;
		double bb = aa;
		System.out.println("aa=" + aa + "\tbb=" + bb);

		// 명시적 형변환 : 큰데이터타입의 값이 작은 데이터타입의 변수로 대입하는 경우 강제 형변환 해야한다.
		double cc = 12.4;
		int dd = (int) cc;
		System.out.println("cc=" + cc + "\tdd=" + dd);

		int plus = (int) (12 + 15.3); // 27
		int zz = 'X' + 3; // 91
		System.out.println("plus=" + plus + "\tzz=" + zz);

	}

}
