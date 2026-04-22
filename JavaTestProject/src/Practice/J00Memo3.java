package Practice;

import java.util.Scanner;

public class J00Memo3 {

	public J00Memo3() {

		Scanner scan = new Scanner(System.in);

		System.out.println("금액을 입력하세요=");
		int won = scan.nextInt();

		int money[] = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		for (int i = 0; i < money.length; i++) {
			int cnt = won / money[i];
			won = won % money[i];
			if (cnt >= 1000) {
				System.out.println(money[i] + "원=" + cnt + "장");
			} else {
				System.out.println(money[i] + "원=" + cnt + "개" );
			}

		}

	}

	public static void main(String[] args) {
		new J00Memo3();

	}

}
