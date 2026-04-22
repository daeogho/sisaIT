package J01_basic;

import java.util.Scanner;

public class J15IfEx {

	public static void main(String[] args) {
		// 년도를 입력받아 윤년인지 평년인지를 구하라.
		// 2월 28일인 해는 평년, 29일인 해는 윤년
		/* 실행
		 * 년도=2024
		 * 윤년
		 * 
		 * 년도=2026
		 * 평년
		 */

		Scanner s = new Scanner(System.in);
		System.out.print("년도입력=");
		int year = s.nextInt();
		String result;
		if(year%4==0 && year%100!=0 || year%400==0) {//윤년
			result = "윤년";
		}else {//평년
			result = "평년";
			}
		System.out.printf("%d년은 %s입니다.", year, result);
	}

}
