package j08Exception;

import java.util.Scanner;

public class TypeCastingEx {

	public TypeCastingEx() {
		// 정수를 -> 실수
		int num = 100;
		double numDou = num;
		double numDou2 = (double)num;
		
		// 실수를 -> 정수
		double data = 12.23;
		int dataInt = (int)data;
		// 객체 형변환
		Scanner scan = new Scanner(System.in);
		Object scan2 = new Scanner(System.in);
		Scanner scan3 = (Scanner)scan2;
		//                                    nextInt()
		// 콘솔에서 입력되는 모든 데이터 문자열로 입력된다... "5" -> 5         "y" -> y     10.5 ->
		
		String empno = "1234"; // -> 숫자 -> 정수 "1234" -> 1234
		Integer empnoObj = new Integer(empno);
		int convert = Integer.parseInt(empno);
		System.out.println(convert + 1000);
		
	}

	public static void main(String[] args) {
		new TypeCastingEx();

	}

}
