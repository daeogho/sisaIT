package J01_basic;

import java.util.Scanner;

public class J13Switch {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in)
				;
		// 1~7까지의 수를 입력받아
		// 1: 일요일, 2: 월요일, 3: 화요일..... 7: 토요일로 출력하고
		// 만약에 1~7사이 아니면 "잘못입력하였습니다."로 출력한다.
		// switch문으로 작성
		
		//switch문 범위 없는 조건문이다. switch, case, default, break
		System.out.print("1~7까지의 수를 입력->");
		int w = s.nextInt();
		String weekName;//요일명을 담을 변수
		switch(w) {// byte, short, int, char, string
		case 1 : 
			weekName = "일요일";
			break;
		case 2 :
			weekName = "월요일";
			break;
		case 3 :
			weekName = "화요일";
			break;
		case 4 : 
			weekName = "수요일";
		    break;
		case 5 :
			weekName = "목요일";
			break;
		case 6 :
			weekName = "금요일";
			break;
		case 7 :
			weekName = "토요일";
			break;
			default :
				weekName = "요일번호를 잘못입력";
		}//switch
		System.out.printf("%d은 %s입니다.", w, weekName);
		
	}

}
