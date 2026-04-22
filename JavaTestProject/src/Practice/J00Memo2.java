package Practice;

import java.util.Calendar;
import java.util.Scanner;

public class J00Memo2 {

	public J00Memo2() {
		// 달력 만들기

		Scanner scan = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();

		System.out.print("년도=");
		int year = scan.nextInt();
		System.out.print("월=");
		int month = scan.nextInt();

		System.out.print("\t\t " + year + "년" + month + "월\n");
		System.out.println("일\t월\t화\t수\t목\t금\t토");

		cal.set(year, month - 1, 1);
		int week = cal.get(Calendar.DAY_OF_WEEK);

		int lastDay = 31;

		switch (month) {
		case 4, 6, 9, 11:
			lastDay = 30;
			break;
		case 2:
			lastDay = 28;
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				lastDay = 29;

			}
		}

		for (int d = 1; d < week; d++) {
			System.out.print("\t");
		}
		for (int day = 1; day <= lastDay; day++) {
			System.out.print(day + "\t");
			if ((week - 1 + day) % 7 == 0) {
				System.out.println();
			}
		}

	}

	public static void main(String[] args) {
		new J00Memo2();

	}

}
