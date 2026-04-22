package J01_basic;

import java.util.Scanner;

public class J11IfElseIf {

	public static void main(String[] args) {
		// 
		Scanner S = new Scanner(System.in);
		int kor, eng, math, total;
		double avg;
		// A, B, C, D, F -> char,String
		String grade; // 학점을 보관할 변수
		
		System.out.print("국어점수=");
		kor = S.nextInt();
		System.out.print("영어점수=");
		eng = S.nextInt();
		System.out.print("수학점수=");
		math = S.nextInt();
		
		total = kor + eng + math;
		avg = total / 3.0;
		
		//학점
		
		if(avg>=90) {
			grade = "A";
			
		} else if(avg>=80) {
			grade = "B";
		} else if(avg>=70) {
			grade = "C";
		} else if(avg>=60) {
			grade = "D";
		} else  {
			grade = "F";
		}
		System.out.printf("총점=%d\n", total);
		System.out.printf("평균=%f\n", avg);
		System.out.printf("학점=%s\n", grade);

	}

	/* 90~100 A학점
	 * 80~89  B학점
	 * 70~79  C학점
	 * 60~69  D학점
	 * 0~59   F학점
	 */
}
