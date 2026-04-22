package Practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class J12RotGame {

	public static void main(String[] args) {
		// 카페 로또 번호 맞추기 게임
		// 조건 = 중복번호제거, 오름차순으로 정렬, 보너스는 마지막 생성된 번호
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		System.out.print("게임수=");
		int game = scan.nextInt();
		
		for(int cnt =0; cnt < game; cnt++) {
			int lotto[] = new int[7];
			
			for(int i =0; i < lotto.length; i++) {
				lotto[i] = ran.nextInt(45)+1;
				
				for(int j=0; j<i; j++) {
					if(lotto[i] == lotto[j]) {
						i--;
						break;
					}
				}
			}
			
		}
			
		
			
		
			
			
		

	}

}
