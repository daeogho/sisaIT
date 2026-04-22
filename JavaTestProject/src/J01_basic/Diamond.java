package J01_basic;

import java.util.Scanner;

public class Diamond {
	Scanner scan = new Scanner(System.in);
	public Diamond(){}
	public void Start() {
		System.out.print("임의의 홀수입력(1~49)=");
		int max = scan.nextInt();
		
		//짝수입력되면 홀수로 변경
		//if, 상향연산자
		if(max%2==0) max ++;
		//= (max%2==0)? max++ : max;
		
		//처음에 출력할 문자
		char str = 'A'; // str =str + 1
		// 증가시 2, 감소시 -2
		int step =2;
		// 삼각형
		for(int i=1; i >=1; i+=step) { // 1,3,5,7,9...max
			// 공백
			for(int j=1; j <= (max-i)/2; j++) { //1,2,3,4,5...(max-i)/2
				System.out.print(" ");				
			}			
			// 문자
			for(int k=1; k<=i; k++) { // 1,2,3...i i가 출력 문자
				System.out.print(str++);
				// 문자가 'Z'보다 크면 'A'로 초기화한다.
				if(str>'Z') str = 'A';
			}
			System.out.println();
			if(max==i) step = -2;
		}
//		// 역삼각형
//		for(int i=max-2; i >=1; i-=2) { // max-2, 21, 19,17
//			//공백
//			for(int j=1; j<=(max-i)/2; j++) { //1,2,3,4,5.. (max-i)/2
//				System.out.print(" ");		
//			}
//			for(int k=1; k<=i; k++) { //1,2,3,4,5...i
//				System.out.print(str++);
//				if(str>'Z') str ='A';
//				
//			}
//			System.out.println();
//			
//		}
		
	
	}
	

	public static void main(String[] args) {
		Diamond dia = new Diamond();
		dia.Start();
		
	}
	
	
}


