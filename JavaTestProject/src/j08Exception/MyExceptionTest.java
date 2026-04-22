package j08Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyExceptionTest {
	Scanner scan = new Scanner(System.in);
	public MyExceptionTest() {
		
	}
	public void start() { // void 는 반환혀이 없다.
		try {
			// 정수(1~100)사이의 그 수까지의 합, 홀수의 합, 짝수의 합
			System.out.print("정수=");
			int max = scan.nextInt(); //
			
			// max의 값이 1~100사이가 아니면 예외 발생시킨다.
			if(max<1 || max>100) {
				// throw : 강제로 예외를 발생 시키는 예약어(keyword)
				// throw new MyException();
				throw new MyException("1에서 100까지의 값만 허용됩니다.");
			}
			
				process(max);
			}catch(InputMismatchException ime){
				System.out.println("정수를 입력하세요..");
			}catch(MyException me) {
				System.out.println(me.getMessage());
			}
	}
	// max의 값까지, 전체합, 홀수합, 짝수의합
	public void process(int max) {
		int sum=0, oddSum=0, evenSum=0;
		for(int i=1; i <= max; i++) {
			sum += i;
			if(i%2 ==0 ) {
				evenSum +=i;
			}else {
				oddSum +=i;				
			}
		}
		System.out.printf("전체합=%d\n짝수의 합=%d\n홀수의 합=%d\n", sum,evenSum,oddSum);
	}
	public static void main(String[] args) {
		new MyExceptionTest().start();

	}

}
