package J01_basic;

import java.util.Scanner;

public class J03OperatorEx2 {

	public static void main(String[] args) {
		// 3장 실습문제 2
		
		Scanner S = new Scanner(System.in);
		System.out.print("과일갯수=");
		int A = S.nextInt();
		System.out.print("바구니크기=");
		int size = S.nextInt();
		
		int cnt = A/size;
	    cnt	= (A%size==0)?  cnt : cnt+1;
	    System.out.printf("바구니수=%d", cnt);
		
	   

	}

}
