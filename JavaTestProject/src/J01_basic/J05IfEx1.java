package J01_basic;

import java.util.Scanner;

public class J05IfEx1 {

	public static void main(String[] args) {
		// 4장 실습문제 
		
		Scanner s = new Scanner(System.in);
		
		int first, second, plus, minus, multifle;
		
		System.out.print("첫번째수=");
		first = s.nextInt();
		System.out.print("두번째수=");
		second = s.nextInt();
		
		if(first>0 && second>0) {
			
			plus = first+second;
			minus = first-second;
			multifle = first*second;
			double nanum = first/(double)second;
			
			System.out.printf("%d+%d=%d\n",first, second, plus);
			System.out.printf("%d-%d=%d\n",first, second, minus);
			System.out.printf("%d*%d=%d\n",first, second, multifle);
			System.out.printf("%d/%d=%f\n",first, second, nanum);
		}
		
		
		

	}

}
