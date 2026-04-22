package Practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class J16GuGudan4 {

	public J16GuGudan4() {
		Scanner scan = new Scanner(System.in);

		do {			
		
		try {
			System.out.print("단="); 
			int num = Integer.parseInt(scan.nextLine());
// ------------------------------ 단 입력-------------------------------------
			if (num < 9) {
			for (int i = 2; i <= 9; i++) {
				for (int j = num - 1; j <= num + 1; j++) {					
					System.out.print(j + "*" + i + "=" + i * j + "\t");
					}
				System.out.println();	
				}
				
			} else {
				System.out.print("1~9까지의 정수를 입력하세요.");
			}
				
//-------------------------------구구단 실행-------------------------------------			

		} catch (InputMismatchException ime) {
			System.out.println("예외 메세지 :" + ime.getMessage());
			System.out.println("정수가 아닌 값을 입력하였습니다...");

		} finally {
			System.out.println("\n-------------------------------");
//------------------------------- 예외 메세지-------------------------------------
		}
		
		}while(true);

	}

	public static void main(String[] args) {
		new J16GuGudan4();

	}

}
