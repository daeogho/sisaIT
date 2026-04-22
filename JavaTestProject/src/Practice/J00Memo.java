package Practice;

import java.util.Scanner;

public class J00Memo {

	public J00Memo() {
		// 입력한 값 까지의 모든 합/ 짝수합/홀수 합을 구하라

		Scanner scan = new Scanner(System.in);

		System.out.print("정수를 입력하세요 =");
		int num = scan.nextInt();

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
		System.out.println("모든합 =" + sum);
		System.out.println("짝수합 =" + evensum);
		System.out.println("홀수합 =" + oddsum);
	}

	public static void main(String[] args) {
		new J00Memo();

	}

}
