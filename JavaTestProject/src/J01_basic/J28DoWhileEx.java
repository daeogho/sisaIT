package J01_basic;

import java.util.Scanner;

public class J28DoWhileEx {

	public static void main(String[] args) {
		// 4장 25pg 실습문제

		Scanner s = new Scanner(System.in);

		System.out.print("임의의 정수 =");
		int num = s.nextInt();
		int i = 1; // 1~ 합하는 변수값 정하고 -> 그 합이 넘으면 break;
		int sum = 0;
		do {
			sum += i; // sum = sum+i 1~값까지의 합

			// sum에 있는 값이 num을 초과했는지 확인
			if (sum >= num) {
				// i, sum을 출력하고 반복문 중지
				System.out.printf("1~%d까지의 합은 %d", i, sum); //i는 값이 나올때까지 계속 증가
				break; // 반복문 중지
			} // 여기까지 했을때 값이 안나오면 다시 위로 올라감 i는 밑에 값으로 인해 1씩 계속 증가
			i++;
		} while (true);

	}

}
