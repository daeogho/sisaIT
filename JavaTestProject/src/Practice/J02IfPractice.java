package Practice;

import java.util.Scanner;

public class J02IfPractice {

	public static void main(String[] args) {
		// 4장 실습문제 1
		
		Scanner s = new Scanner(System.in);
		/*int first, twice;
		
		System.out.print("첫번째수=");
		first = s.nextInt();
		System.out.print("두번째수=");
		twice = s.nextInt();
		
		if(first>0 || twice>0) {
					int plus = first + twice;
					int minus = first - twice;
					int gop = first * twice;
					int nanum = first / twice;
					
					System.out.printf("%d+%d=%d\n", first, twice, plus);
					System.out.printf("%d-%d=%d\n", first, twice, minus);
					System.out.printf("%d*%d=%d\n", first, twice, gop);
					System.out.printf("%d/%d=%d\n", first, twice, nanum);
					
		}
		
		System.out.println("\n=====End=====");
		*/
		
		// 4장 실습문제 2
		
		
		/*int length, height, menu, radius;
		
		System.out.print("원하는 메뉴를 선택(1.사각형의 넓이, 2.원의 넓이)?");
		menu = s.nextInt();
		
		if(menu==1) {
			System.out.print("가로(밑변)=");
			length = s.nextInt();	
			System.out.print("세로(높이)=");
			height = s.nextInt();
			
			int area = height*length;
			System.out.printf("사각형의 넓이=%d", area);
			
			System.out.println("\n=======End=======");
		}
		
		if(menu==2) {
			System.out.print("반지름=");
			radius = s.nextInt();
			
			double carea = radius*radius*Math.PI; // Math.PI = 3.14...(더 자세한 반지름 값)
			System.out.printf("원의 넓이=%f", carea);
			
			System.out.println("\n=======End=======");
			
		}*/
		
		// 실습문제 3
		
		int jung, kyo, illban;
		
		System.out.print("전공 이수 학점=");
		jung = s.nextInt();
		System.out.print("교양 이수 학점=");
		kyo = s.nextInt();
		System.out.print("일반 이수 학점=");
		illban = s.nextInt();
		
		int jolup = jung+kyo+illban;
		int kyoill = kyo+illban;
		
		if(jolup>=140 || jung>=70 && kyo>=30 && illban>=30 && kyoill >=80) {
			
			System.out.printf("졸업가능");
		}
		
		

	}

}
