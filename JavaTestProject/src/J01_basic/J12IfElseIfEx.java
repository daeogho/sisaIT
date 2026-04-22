package J01_basic;

import java.util.Scanner;

public class J12IfElseIfEx {

	public static void main(String[] args) {
		// 1~7까지의 수를 입력받아
		// 1:일요일, 2:월요일, 3:화요일 ..... 7:토요일로 출력하고
		// 만약에 1~7사이의 값이 아니면 "잘못입력하였습니다."로 출력한다.

		Scanner s = new Scanner(System.in);
		
		System.out.print("1~7사이의 숫자를 입력하세요.=");
		int num = s.nextInt();
		String result;
		
		if(num>7) 
			result ="잘못입력하였습니다."; //num==1로 시작하고 마지막에 else로 마무리
			
		
		 else if(num==1) 
			result = "일요일";
		 else if(num==2) 
			result = "월요일";
		 else if(num==3) 
			result = "화요일";
		 else if(num==4) 
			result = "수요일";
		 else if(num==5) 
			result = "목요일";
		 else if(num==6) 
			result = "금요일";
		 else if(num==7) 
			result = "토요일";
		 else 
		result = "잘못입력하였습니다.";
	
		System.out.printf("=%s\n", result);
	
	}
}
