package J01_basic;

import java.util.Scanner;

public class J26WhileEx {

	public static void main(String[] args) {
		// 4장 26pg 실습문제

		Scanner s = new Scanner(System.in);

		while (true) { // true, false <-- a>10 a<10 a>=0 a<=0
			System.out.print("정수 =");
			int max = s.nextInt();

			// 홀수의 합, 짝수의 합 구하기
			// 초기값
			int i = 1;
			int oddSum = 0, evenSum = 0;// 홀수핪, 짝수합 보관할 변수
			while (i <= max) {
				if (i % 2 == 0) {// i는 짝수
					evenSum += i;
				} else {// 홀수
					oddSum += i;
				}
				i++;// 다음수
			}
			System.out.printf("홀수의 합 = %d\n", oddSum);
			System.out.printf("짝수의 합 = %d\n", evenSum);
		}

	}

}
