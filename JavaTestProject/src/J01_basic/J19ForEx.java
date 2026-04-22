package J01_basic;

import java.util.Scanner;

public class J19ForEx {

	public static void main(String[] args) {
		// 4장 실습 문제
		
		Scanner s = new Scanner(System.in);
		System.out.print("단=");
		int num = s.nextInt();
		
		for(int i = 2; i<=9; i++) {
			int gop = num * i;
			System.out.printf("%2d * %2d = %2d\n", num, i, gop);
		}
			

	}

}
