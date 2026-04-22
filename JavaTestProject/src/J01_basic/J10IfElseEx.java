package J01_basic;

import java.util.Scanner;

public class J10IfElseEx {

	public static void main(String[] args) {
		// 두수를 입력받아 큰수부터 출력하라.
		// 수1 = 30           100
		// 수2 = 50		      50
		// 50           100
		// 30            50

		
		Scanner s = new Scanner(System.in);
		
		System.out.print("수1=");
		int su1 = s.nextInt();
		System.out.print("수2=");
		int su2 = s.nextInt();
		
		if(su1 < su2) { //su1의 결과 su2의 값 교환하기
			int temp = su1;
			su1 = su2;
			su2 = temp;
		
//		if(su1>su2) {
//			System.out.println(su1);
//			System.out.println(su2);
//			
//		}else {
//			System.out.println(su2);
//			System.out.println(su1);
//			
		}
		System.out.println(su1);
		System.out.println(su2);
	
		
	}

}
