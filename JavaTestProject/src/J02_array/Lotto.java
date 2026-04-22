package J02_array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		// 카페 실습 문제로또 게임
		// 게임수 -> 게임생성 -> 계속 여부
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		do {
			System.out.print("게임수 = ");
			int game = scan.nextInt();
			// 게임수 만큼 반복 하여 로또게임을 생성한다.
			for(int cnt =1; cnt<=game; cnt++) { // 1개의 게임생성
				int lotto[] = new int[7];
				
				for(int i =0; i < lotto.length; i++ ) { //0,1,2,3,4,5,6
					// 번호생성, 중복검사 동시 처리
					lotto[i] = ran.nextInt(45)+1; // 1 ~ 45 숫자 생성
					// ----------------- 중복 검사-------------------
					for(int j =0; j < i; j++) { //처음에는 반복 안함 인덱스 자체가 false 이기때문 -> j<i = 0<0
						if(lotto[i] == lotto[j]) { // 중복
							i--; // --i, i= i-1, i -= 1
							break; //i--로 인해 앞뒤가 같으면 다시 번호를 생성, 같은 숫자가 없으면 break;
						}
						
					}
											
				}
				// 정렬 -> 출력
				Arrays.sort(lotto, 0, 6); // index 6앞까지 정렬
				
				// 문자열 만들기 [5,6,7,8,9,4,6] => [5,6,7,8,9,4]
				String lottoTxt = Arrays.toString(Arrays.copyOfRange(lotto, 0, 6));
				
				// 출력				
				System.out.print(cnt+"게임 =");
				System.out.print(lottoTxt);
				System.out.println(", bonus = " + lotto[6]);
				
				
			}
			// 계속 여부
			System.out.print("계속하시겠습니까((1.예, 2.아니오)?");
			int que = scan.nextInt();
			if(que ==2) {
				break; // que가 2이면 종료
				
			}
		}while(true);

	}

}
