package Practice;

public class J04ForPractice {

	public static void main(String[] args) {
		// 4장 실습문제

		int i, j;
		for (i = 1; i <= 5; i++) { // i가 1일때 j는 5 / i가 2일때 j는 4 / i가 3일떄 j는 3
			for (j = 1; j <= 6 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (i = 5; i >= 1; i--) {
			for (j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
