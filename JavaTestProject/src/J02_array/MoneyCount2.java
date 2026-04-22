package J02_array;

import java.util.Scanner;

public class MoneyCount2 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 배열을 사용하지 않고 화폐수를 구한다.
		
		System.out.print("금액입력=");
		int cash = scan.nextInt();
		
		int danwi = 50000; //화폐단위
		int value = 5; // 처음으로 나눈 단위 
		
		while(cash>0) {
			//화폐를 구하여 출력
			int cnt = cash / danwi; // 그 단위의 금액에서 몇장인지 구하는
			if(cnt>0) {
				System.out.printf("%d원="+"%d%s\n", danwi, cnt, (danwi>=1000)? "장" : "개"); // 삼항연산을 통해 장,개로 나누기
				
				cash = cash % danwi; // 다음 단위의 금액을 정하는 
			}
			// 다음 단위 화폐 계산식----------------------------------------------------------
			danwi = danwi / value ;
			
			if(value ==5) {
				value = 2;
			} else {
				value = 5;
			}
		}
		
	}

}
