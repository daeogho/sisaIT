package J01_basic;

import java.util.Scanner;

public class J09IfElseEx {

	public static void main(String[] args) {
		// 숫자를 입력받아 양수 또는 음수이면 입력받은 값에 100을 곱하여 출력
		// 단, 음수이면 양수로 만들어야 한다.
		// 0이 입력되면 0을 1로 바꿔서 출력

		
		Scanner s = new Scanner(System.in);
		
		System.out.print("정수입력=");
		int num = s.nextInt();
		int result = 0;
		
		if(num<0) {
			result = -num * 100;
		} else { 
			
			if(num>0) {
			result = num * 100;
			} else {
				result = 1;
			}
		}
		System.out.printf("결과=%d", result);
		
	}

}
