package j08Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionMethod {

	public ExceptionMethod() {
	}
	
	public void start() throws ArithmeticException, InputMismatchException{
		inData();
	}
	public void inData() throws ArithmeticException, InputMismatchException{
		Scanner scan = new Scanner(System.in);
		System.out.print("정수=>");
		int data = scan.nextInt(); //
		process(data);
	}
	public void process(int data) throws ArithmeticException {
		int result = 2000 / data; //
		output(result);
	}
	public void output(int result) {
		System.out.println("result=" + result);
	}
	public static void main(String[] args) throws ArithmeticException, InputMismatchException{
		try {
			new ExceptionMethod().start();
		}catch(InputMismatchException ime) {
			System.out.println(ime.getMessage());
			System.out.println("정수를 입력하지 않았습니다.");
		}catch(ArithmeticException ae) {
			System.out.println(ae.getMessage());
			System.out.println("0으로 나눌 수 없습니다.");
		}
	}

}
