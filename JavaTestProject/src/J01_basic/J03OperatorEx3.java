package J01_basic;

import java.util.Scanner;

public class J03OperatorEx3 {

	public static void main(String[] args) {
		// 카페 연산자문제 2 
		
		Scanner S = new Scanner(System.in);
		
		System.out.print("정수=");
		int A = S.nextInt();
		//int B = A / 100* 100;
		int B = A-(A%100);
		System.out.printf("결과=%d\n", B);

//------------------------------------------------------
	
		System.out.print("정수=");
		int AA= S.nextInt();
		//int BB = 1+(AA /10 * 10);
		int BB = AA-(AA%10)+1;
		System.out.printf("결과=%d\n", BB);

//------------------------------------------------------
		
		System.out.print("문자=");
		int C = S.nextInt();
		int
		BBB = C-4;
		System.out.printf("결과=%c", BBB);

	}

}
