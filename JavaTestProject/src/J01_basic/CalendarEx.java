package J01_basic;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarEx {

	public static void main(String[] args) {
		// 11장 17page 달력
		
		Scanner s = new Scanner(System.in);
		System.out.print("년도=");
		int year = s.nextInt();
		System.out.print("월=");
		int month = s.nextInt();
		
		System.out.printf("\t\t %d 년 %d월\n", year, month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
	//========================= 달력 일수 출력 ====================
		
		Calendar c = Calendar.getInstance(); //오늘날짜 달력 import
		c.set(year, month-1, 1); //월은 0->1월, 1->2월 // 마지막 숫자 1 => 그달에 무슨요일부터 시작하는지를 표기하는 수 
		int week = c.get(Calendar.DAY_OF_WEEK); //1일의 요일 구하기 1일,2월,3화,4수...		
		// 30일 : 4,6,9,11 
		// 31일 : 1,3,5,7,8,10,12
		// 2월 = 28,29(윤년)
		
		int lastDay = 31; // 마지막 날짜 변수
		switch(month) { // month 값이 ~ 일때 case 숫자에 따라 적용
		case 4,6,9,11 : lastDay =30; break;
		case 2 : lastDay =28;
		if(year%4 ==0 && year%100 !=0 || year%400 ==0) {
			lastDay = 29;
		}
		}
		// 요일을 이용하여 공백처리------------------------------------
		for(int d=1; d<week; d++) { // d : 공백처리를 하기위한 변수
			System.out.print("\t");
		}
		// 날짜 출력-------------------------------------------------
		for(int day=1; day<=lastDay; day++) { //day : 요일에 숫자?
			System.out.print(day+"\t");
			// 줄 맞춤--------------------------------------			
			if((week-1+day)%7==0) { // 공백수+출력한 날짜수가 7의 배수
				System.out.println();
			}
		}
		System.out.println();

	}

}
