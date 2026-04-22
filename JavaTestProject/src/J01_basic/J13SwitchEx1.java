package J01_basic;

import java.util.Scanner;

public class J13SwitchEx1 {

	public static void main(String[] args) {
		// 월을 입력받아 해당하는 계절명을 출력하라
		// 10 ~ 2 -> 겨울
		// 3,4 ->봄
		// 5 ~8 ->여름
		// 9 -> 가을
		// 1~12사이의 값이 아니면 "월을 잘못입력하였습니다." 라고 출력
		
		Scanner s = new Scanner(System.in);
		System.out.print("1~12사이의 숫자를 입력하세요.");
		int season = s.nextInt();
		
		String seasonName;
		switch(season) {
		case 11:
		case 12:
		case 1 :
		case 2 :
			seasonName = "winter";
			break;
		case 3 : 			
		case 4 :
			seasonName = "spring";
			break;
		case 5 :
		case 6 :
		case 7 :
		case 8 :
			seasonName = "summer";
			break;
		case 9 :
		case 10 :
			seasonName = "fall";
			break;
			default :
				seasonName = "잘못된 입력";
				
				
		}
		System.out.printf("%d월은 %s입니다.", season, seasonName);

	}

}
