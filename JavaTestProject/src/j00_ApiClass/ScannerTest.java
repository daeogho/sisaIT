package j00_ApiClass;

//import java.util.Scanner; , Scanner 뒤에 Ctrl+Space = Enter 자동으로 입력됨
//java.lang팩키지외의 클래스는 반드지 import해야 한다.

import java.util.Scanner;

// API클래스나 생성한 클래스도 다른 클래스에 사용하기 위해서는 
// 객체를 생성하여야 사용할 수 있는 클래스가 있고
// 객체를 생성하지 않아도 사용할 수 있는 클래스가 있다. : System, String

public class ScannerTest {

	public static void main(String[] args) {
		// Scanner클래스 테스트
		// Scanner 클래스는 반드시 객체를 만들어서 사용해야 한다.
		
		Scanner scan = new Scanner(System.in);
		//      =레퍼런스,인스턴스 변수
		
		//실행중 콘솔에서 문자를 입력받기
		
		//객체를 사용하기 객체명.메소드, 객체명.변수
		// next() : 단어 1개 입력
		// nextline() : 1줄을 입력
		
		//System.out.print("문자열입력=");
		//String inData = scan.nextLine();
		//String inData = scan.next();
		//System.out.printf("inData=%s\n", inData);
		
		// 숫자 입력받기
		// 정수(byte, short, int, long), 실수(float, double), 논리(boolean)
		
		System.out.print("정수입력=");
		int inNum = scan.nextInt(); //콘솔에서 문자를 입력받아 정수로 변환하여 리턴하는 기능을 가지고 있다.
		
		System.out.printf("%d-->%d\n", inNum, inNum*10);
		
		System.out.print("실수입력=");
		double inDouble = scan.nextDouble(); //콘솔에서 문자로 입력받아 실수로 변환하여 리턴한다.
		System.out.printf("%f --> %f\n", inDouble, inDouble*10);
		

	}

}
