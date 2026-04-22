package Practice;

import java.util.Scanner;

public class J10CafePractice {

	public static void main(String[] args) {
		// 1~100사이의 난수를 만들어 맞추는 게임을 작성하라.

		Scanner scan = new Scanner(System.in);
		System.out.print("숫자 맞추기 게임\n"); // 난수 1~100사의 범위 정해주기 -> 입력하여 반복하여 답구하기
	
		double random = Math.random();
		int rndNum = (int)(random * (100 - 1 + 1)) + 1; // 값이 고정
		int i=1;
		A: for (i = 1; ; i++) { //범위는 num를 몇번 입력했는지

			 System.out.printf("1~100사이의 정수를 입력하세요.?="); 
			int num = scan.nextInt();
			
			
				if (num == rndNum) {
					System.out.printf("맞추었습니다... 난수=%d\n", rndNum);	break A;		

					}else if (num < rndNum) {
						System.out.print("더 큰 값을 입력하세요....\n");		
					}else {
						System.out.print("더 작은값을 입력하세요....\n");
					}
			} System.out.print(i+"번만에 맞추었습니다...");
						
				 
	}

}
