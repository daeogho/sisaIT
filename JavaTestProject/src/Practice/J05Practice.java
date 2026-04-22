package Practice;

import java.util.Scanner;

public class J05Practice {

	public static void main(String[] args) {
		/*
		 * 실행
		 * 단 = 5
		 * 5*2=10
		 * 5*3=15
		 * ...
		 * 5*9=45
		 * (반복)
		 */
		Scanner s = new Scanner(System.in);
		
		for( ; ; ) {
			System.out.printf("단 입력 =");
			int num = s.nextInt();
			
			if( num>=1 && num<=9) {
			for(int i = 1;i <=9 ;i++) {							
			int gop = i * num;
			System.out.printf("%d" + "*" + "%d" + "=" + "%d\n", num, i, gop);
				}
			}else {
				System.out.println("단을 잘못입력하였습니다.");
			}
				
		}
				

	}

}
