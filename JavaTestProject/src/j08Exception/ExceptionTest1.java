package j08Exception;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest1 {
	Scanner scan = new Scanner(System.in);
	public ExceptionTest1() {		
	}
	public void start() {
		// 예외처리 : try {
		
		//		 } catch{
		
		//       } finally{
		
		//       }
		do {
		// 두 정수를 입력받는다.
		try {
			// 정상코드, 예외 발생가능성이 있는 코드를 기술한다.			
				System.out.println("첫번째 정수=");
				int n1 = Integer.parseInt(scan.nextLine()); //InputMismarchedException 정수가 아닌 값을 입력하면
				System.out.println("두번째 정수=");
				int n2 = Integer.parseInt(scan.nextLine()); 
		
				double result = divide(n1, n2);
				System.out.println(n1 + "/" + n2 + " = " + result);
				
		} catch(InputMismatchException ime) {
			// InputMismatchException 예외가 발생하면 실행되는 곳
			System.out.println(ime.getMessage()); // 에러메시지 떴을때 표시되는 것
			System.out.println("정수가 아닌 값을 입력하였습니다.");
			
		} catch(NumberFormatException nfe) {
			System.out.println("예외메시지 : " + nfe.getMessage());
			System.out.println("문자를 입력하였습니다. 숫자를 입력하세요...");
			nfe.printStackTrace(); // 에러메시지를 뜨게 해주는 수식
			
		} catch(ArithmeticException ae) { // 영어나 문자를 넣었을때 잘못됬다고 해주는 수식
			System.out.println("예외메시지 :" + ae.getMessage());
			System.out.println("0으로 어떤 수를 나눌 수 없습니다.");
		} finally {
			// 예외가 발생여부와 상관없이 무조건 실행된다.
			// DB연동 데이터 사용시 필요하다.
			System.out.println("finally실행됨...");
		}
	}while(true);
		
	}
	// 나누기 메소드
	public double divide(int a, int b) {
		/*
		 *  정수 / 정수(0) : ARithmeticException
		 *  실수 / 정수(0) : 무한대 
		 */
		double result = a / b; // ArithmeticException
		return result;
	}
	
//-----------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		new ExceptionTest1().start();

	}

}
