package J01_basic;

import java.util.Scanner;

public class J07IfEx3 {

	public static void main(String[] args) {
		// 4장 실습문제2

		//대학을 졸업하기 위해서는 최소 140학점을 이수하여야한다. 이수한 학점 중 전공은 70학점 이상
		//이어야 하며, 교양과 일반은 각각 30학점 이상이거나 총점이 80점 이상이어야 한다.
		//이수한 학점을 각각 입력 받아 졸업여부를 출력하는 프로그램을 작성하라.
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("전공 이수 학점=");
		int major = s.nextInt();
		System.out.print("교양 이수 학점=");
		int liberal = s.nextInt();
		System.out.print("일반 이수 학점=");
		int general = s.nextInt();
		
		int total = major + liberal + general;
		int total2 = liberal + general;
		
		if(total >= 140 && major >= 70 && ((liberal >=30 && general >= 30) || total2 >= 80)) {
			System.out.println("졸업가능");
		}
	}

}
