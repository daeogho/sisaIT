package j08Exception;

import java.util.Scanner;

public class ExceptionTest2 {
	Scanner scan = new Scanner(System.in);
	public ExceptionTest2() {}

	public void start() {
		try {
			
		
			System.out.print("정수입력=");
			int data = scan.nextInt(); // inputMismatchException
			
			int result = 1000 / data; // ArithmeticException
			
			int arr[] = {43, 65, 76, 87, 87};
			
			for(int i =0; i <= arr.length; i++) {
				System.out.println(arr[i]); // ArrayIndexOutOfBoundException
			}
		
		} catch(ArrayIndexOutOfBoundsException aiobe) {
			System.out.println("배열의 점자(index)같이 잘못되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ExceptionTest2().start();

	}

}
