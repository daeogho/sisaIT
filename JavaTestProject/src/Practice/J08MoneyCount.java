package Practice;

import java.util.Scanner;

public class J08MoneyCount {

	public static void main(String[] args) {
		// 카페문제 화폐의 수를 구하기
		Scanner scan = new Scanner(System.in);
		
		int money1[] = {50000, 10000, 5000,1000};
		int money2[] = {500,100,50,10,5,1};
		int count1[] = new int[4];
		int count2[] = new int[6];
		
		System.out.print("금액을 입력하세요?=");
		int num = scan.nextInt();
		
		for(int i =0; i < money1.length;i++) { 
						
			count1[i] = num/money1[i]; //  = 56000/50000
			num %= money1[i]; 
					
			System.out.println(money1[i]+"원=" + count1[i]+"장");									
			}
		
		for(int j=0; j<money2.length;j++) {
			
			count2[j] = num/money2[j]; //금액을 화폐에 맞게 분류 식
			num %= money2[j];
						
			System.out.println(money2[j]+"원=" + count2[j]+"개");		
			}
				

	}

}
