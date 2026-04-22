package j00_ApiClass;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		// 실습 문제
		
		Scanner s = new Scanner(System.in);
		// 데이터 준비
		System.out.print("숫자->");
		int A = s.nextInt();
		// 처리 - 계산
		String B = (A%2==1)? "홀수" : "짝수";
		
		// 출력
		System.out.printf("%d은 %s입니다.", A, B);
		

	}

}
