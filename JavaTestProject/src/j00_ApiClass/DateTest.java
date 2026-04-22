package j00_ApiClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// Date를 이용 날짜 처리하기
		
		Date date = new Date();
		System.out.println(date);
		
		SimpleDateFormat frt = new SimpleDateFormat("오늘은 yyyy년 MM월 dd일 (E) HH시 mm분 ss초 a");
		
		String dateFormat = frt.format(date);
		System.out.println(dateFormat);
	}

}
