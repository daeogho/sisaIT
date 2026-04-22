package J01_basic;

import java.util.Scanner;

public class StandardWeight {

	public static void main(String[] args) {
		// 4장 실습과제
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("나이=");
		int age = s.nextInt();
		System.out.print("성별(1:남, 2:여)=");
		int gender = s.nextInt();
		System.out.print("키=");
		int cm =s.nextInt();
		System.out.print("현재체중=");
		int kg =s.nextInt();
		
	double pkg, index;
	String result; 
	
	if (gender == 1 && age >= 36) {
		pkg = (cm-100) * 0.95;
	}else if(gender == 1 && age <=35 || gender == 2 && age >= 36) {
		pkg = (cm-100) * 0.90;
	}else {
		pkg = (cm-100) * 0.85;
	}
	System.out.printf("표준체중=%.1f\n", pkg);
	 
	index = kg/pkg*100;
	if (index<=85)
		result = "마른형";
	else if (index>=86 && index<=95)
		result = "조금마른형";
	else if (index>=96 && index<=115)
		result = "표준형";
	else if (index>=116 && index<=125)
		result = "조금 비만형";
	else
	result = "비만형";
	
	System.out.printf("당신은 표준체중지수는 %.2f으로 %s입니다.", index, result);
	
	  
	 
	}
}
