package j00_ApiClass;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		// 현재 시스템의 날짜, 시간과 관련있는 모든 정보를 제공하는 클래스
		// Data, Calendar, GregorianCalendar
		
		// 클래스 사용방법
		// 1. System.out.println();
		// 2. Scanner scan = new Scanner(System.in);
		// 3. Calendar now = Calendar.getInstance(); // getInstance() => Calendar를 객체로 만들어서 리턴해주는 메소드
		
		Calendar now = Calendar.getInstance();
		
		// set() : 새로운 데이터를 설정할 때
		// 년,월,일,시,분을 가지고 바꾸는 방법
		//now.set(2026,4,14,9,13);
		// 년,월,일,시,분,초
		now.set(2027,2,15,12,29,30);
		// 년,월,일
		now.set(2024,9,29);
		
		// 년,월,일,시,분,초 중에 1개만 변경하는 방법
		// 무엇을 변경할것인지, 변경될 값
		now.set(Calendar.YEAR, 2025); //년도만 변경
		now.set(Calendar.HOUR_OF_DAY, 5); //시간만 변경
		
		//2025-		
		//System.out.println(now);
		
		// 2025-11-11(화) 14시 50분 02:50PM
		// 년도를 Calendar객체에 얻어오기

		int year = now.get(Calendar.YEAR);
		
		int month = now.get(Calendar.MONTH) + 1; // 0->1월 1->2월
		int day = now.get(Calendar.DATE);
		int week = now.get(Calendar.DAY_OF_WEEK); // 1-> 일요일, 2-> 월요일, 3->화요일, ........, 7->토요일
		String weekName = "";
		switch(week) {
		case 1: weekName = "일"; break;
		case 2: weekName = "월"; break;
		case 3: weekName = "화"; break;
		case 4: weekName = "수"; break;
		case 5: weekName = "목"; break;
		case 6: weekName = "금"; break;
		case 7: weekName = "토"; break;
		}
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		System.out.printf("%d-%d-%d(%s)%d:%d\n", year, month,day,week,hour,minute);
		////////////////////////////////////////////
		now.set(2025, 10,11);
		int date = now.get(Calendar.DAY_OF_YEAR);
		int joo = now.get(Calendar.WEEK_OF_YEAR);
		System.out.printf("오늘은 %d째 이며, 올해의 %d주차입니다.", date,joo);
		// 오늘은 ____째입니다.
	}

}

