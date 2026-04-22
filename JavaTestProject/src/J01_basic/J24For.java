package J01_basic;

public class J24For {

	public static void main(String[] args) {
		// 중첩 for문 4장 실습문제
		for(int i = 1; i <=5 ; i++) { //줄수
			
			for(int j = 1; j <=i ; j++) { //칸수
				//System.out.print(" i=" + i + ", j=" + j + "/");
				System.out.print("*");
			}
			// 줄바꿈
			System.out.println();
		}
		// 문제 3번
		for (int row = 1; row <= 5; row++) { // i가 1일때 j는 5 / i가 2일때 j는 4 / i가 3일떄 j는 3
			for (int col = 1; col <= 6 -row; col++) {
				System.out.print("x");
			}
			System.out.println();
		}
		
		for (int row = 5; row >= 1; row--) {
			for (int col = 1; col <= row; col++) {
				System.out.print("x");
			}
			System.out.println();
		}
		// 문제 4번
		for(int q=1; q <=5; q++) { //1,2,3,4,5
			//공백출력          		 4,3,2,1,0
			for(int space =1; space <= 5-q; space++) {
				System.out.print(" ");				
			}
			for(int w=1; w<=q; w++) {
				System.out.print("A");
			}
			System.out.println();
		}
		for(int i =5; i >=1; i--) {
			for(int j =1; j <=5-i; j++) {
				System.out.print(" ");
			}
			for(int k=1; k<=i; k++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i =1; i<=5; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
