package J01_basic;

import java.util.Scanner;

public class J14SwitchEx2 {

	public static void main(String[] args) {
		// 4장 실습문제
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("국어점수=");
		int kor = s.nextInt();
		System.out.print("영어점수=");
		int eng = s.nextInt();
		System.out.print("수학점수=");
		int math = s.nextInt();
		
		int total = kor + eng + math;
		double average = total / 3.0;
		
		String grade;
		switch((int)(average/10)) {
		
		case 10,9 :
		        grade = "A";
			break;
		case 8 :
			grade = "B";
			break;
		case 7 :
			grade = "C";
			break;
		case 6 :
			grade = "D";
			break;
			
			default :
				grade = "F";			
		
		}
		System.out.printf("총점=%d\n", total);
		System.out.printf("평균=%f\n", average);
		System.out.printf("학점=%s\n", grade);

	}

}
