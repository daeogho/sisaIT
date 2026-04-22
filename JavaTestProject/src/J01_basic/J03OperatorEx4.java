package J01_basic;

import java.util.Scanner;

public class J03OperatorEx4 {

	public static void main(String[] args) {
		Scanner S = new Scanner(System.in);
		
		System.out.print("알파벳(A-Z)까지 입력=");
		String str = S.next(); // "A" -> 'A', "B" -> 'B', "C" -> 'C'
		
		// 문자열을 문자로 바꿔야 계산이 가능하다.
		// 문자열을 문자로 바꾸는 것은 String클래스에 메소드가 존재한다.
		
		char c = str.charAt(0);
		//char result = (char)(c+32);
		//char result2 = (char)(c-32);
		
		char result = (c>='A' && c<='Z')? (char)(c+32) : (c>='a' && c<='z')? (char)(c-32) : '-';
		//          대문자 -> 소문자					   소문자 -> 대문자
		System.out.printf("결과=%c\n", result);
		
		
	
		
	}
	

}
