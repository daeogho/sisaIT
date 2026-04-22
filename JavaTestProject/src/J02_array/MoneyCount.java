package J02_array;

import java.util.Scanner;

public class MoneyCount {

	public static void main(String[] args) {
		// 금액을 입력받아 화폐의 수를 구하여 출력하라.
		// 금액단위를 배열에 담기
		
		Scanner scan = new Scanner(System.in);
		
		int danwi[] = {50000,10000,5000,1000,500,100,50,10,5,1};
		
		//금액입력
		System.out.print("금액을 입력하세요?=");
		int money = scan.nextInt();
		
		for(int i=0; i<danwi.length; i++) { // i=0 일때 5만원, i=1 일떄 1만원
				//화폐수 계산수
			int cnt = money / danwi[i];
			money = money%danwi[i];
			//money = money -danwi[i] * cnt; 
			// 화폐수가 0이상 일때 출력
			if(cnt>0) {
				System.out.printf("%d원=" + "%d%s\n" ,danwi[i], cnt, (danwi[i]>1000)? "장" : "개");
				// 현재 화폐단위의 금액만큼 빼기
			}
				
			}

	}

}
