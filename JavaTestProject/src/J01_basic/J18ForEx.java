package J01_basic;

import java.util.Scanner;

public class J18ForEx {

	public static void main(String[] args) {
		// 임의의 양의 정수를 입력받아
		// 그 수까지의 합, 짝수합, 홀수합을 구하라.
		/*
		 * 실행 양의 정수 = 25 1~25까지의 합은 -- 1~25까지의 홀수의 합은 -- 1~25까지의 짝수의 합은 --
		 */
		Scanner s = new Scanner(System.in);
		System.out.print("양의정수=");
		int num = s.nextInt();
		// 전체합 홀수합

		int sum = 0, oddSum = 0, evenSum = 0;

		for (int i = 1; i <= num; i++) { // 1,2,3,4,5....
			// 전체합
			sum += i; // sum = sum + i;
			if (i % 2 == 1) {// 홀수
				oddSum += i;
			} else {// 짝수
				evenSum += i;
			} // if
		} // for
		System.out.printf("1~%d까지의 합은 %d\n", num, sum);
		System.out.printf("1~%d까지의 홀수의 합은 %d\n", num, oddSum);
		System.out.printf("1~%d까지의 짝수의 합은 %d\n", num, evenSum);

	}

}
