package J02_array;

import java.util.Scanner;

public class J35ArrayEX {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/* 
		 * 실행
		 * 국어점수= --
		 * 영어점수= --
		 * 수학점수= --
		 * 
		 * 총점=
		 * 평균=
		 */
		
		//데이터 준비
		String title[] = {"국어", "영어", "수학"};
		double jumsu[] = new double[5];
		 
		for(int i = 0; i < title.length; i++) { //0 1 2
			System.out.print(title[i] + "점수=");
			jumsu[i]= scan.nextDouble();
			jumsu[3] += jumsu[i];
			jumsu[4] = jumsu[3]/title.length;
		}
		System.out.println("총점=" + jumsu[3]);
		System.out.println("평균=" + jumsu[4]);
//-----------------------------------------------------------------		
		for(double jum : jumsu) {
			System.out.println(jum);
			
			
		}

	}

}
