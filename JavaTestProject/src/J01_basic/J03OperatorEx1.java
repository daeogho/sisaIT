package J01_basic;

import java.util.Scanner;

public class J03OperatorEx1 {

	public static void main(String[] args) {
		// 3장 실습문제 1
		
		Scanner S = new Scanner(System.in);
		
		System.out.print("급여->");
		int Pay = S.nextInt();
		
		double Bonus = (Pay<100)? Pay*0.2 : Pay*0.1;
		System.out.printf("보너스->%.0f\n", Bonus);
		
		

	}

}
