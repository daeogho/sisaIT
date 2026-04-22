package J01_basic;

import java.util.Scanner;

public class J03OperatorEx5 {

	public static void main(String[] args) {
		// 국어, 영어, 수학점수를 입력받아 총점과 평균을 구하는 프로그램작성
		// 국어, 영어, 수학점수는 0~100점사이이고 정수이다.
		// 평균은 소수이하 2자리까지 구한다.
		
		/*
		 * 실행
		 * 국어점수 = 
		 * 영어점수 =
		 * 수학점수 = 
		 * 총점 =
		 * 평균 = -.-
		 */
		
		Scanner S = new Scanner(System.in);
		// int kor, eng, math, total; 하고 나면 앞에 int안 붙여도 됨 (추후 변수확인이 편함)
		// double average;
		
		System.out.print("국어점수=");
		int kor = S.nextInt();
		System.out.print("영어점수=");
		int eng = S.nextInt();
		System.out.print("수학점수=");
		int math = S.nextInt();
		
		int total = kor + eng + math;
		double average = (double)total / 3.0;
		
		
		System.out.printf("총점=%d\n", total);
		System.out.printf("평균=%.2f\n", average);
		
		
	}

}
