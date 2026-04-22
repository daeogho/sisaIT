package J01_basic;

import java.util.Scanner;

public class J08IfElse {

	public static void main(String[] args) {
		// 어떤 정수를 입력받아 1~100 사이이면 입력받은 값의 3배를 하여 출력하고
		// 1~100사이가 아니면 "잘못입력되었습니다."라고 출력한다.
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("임의의 정수입력=");
		int num = s.nextInt();
		
		if(0<num && num<=100) {
			
			int result = num*3;
			System.out.printf("%d의 3배는 %d이다.", num, result);
			
		} else {
			
			System.out.println("잘못입력되었습니다.");
			
		}
		
		
		
		

	}
	

}
