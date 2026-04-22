package test;

import java.util.Scanner;

public class Question2 extends Exception {

	public Question2() {

		Scanner scan = new Scanner(System.in);

		do {
			System.out.print("정수입력=");
			int num = scan.nextInt();

			if (1 <= num && num <= 1000) {

				int sum = 0, oddsum = 0, evensum = 0;
				for (int i = 1; i <= num; i++) {
					sum += i;
					int j = i % 2;
					if (j == 0) {
						evensum += i;
					} else {
						oddsum += i;
					}
				}

				System.out.printf("1~%d까지의 합은 %d\n", num, sum);
				System.out.printf("1~%d까지의 짝수의 합은 %d\n", num, evensum);
				System.out.printf("1~%d까지의 홀수의 합은 %d\n", num, oddsum);
			} else {
				System.out.print("잘못입력된 값입니다.\n");
			}
		} while (true);

	}

	private void Exception(String string) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new Question2();

	}

}
