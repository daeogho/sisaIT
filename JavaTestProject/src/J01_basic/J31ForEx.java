package J01_basic;

public class J31ForEx {

	public static void main(String[] args) {
		// 4장 21page 실습문제
		
		for(int i=1; i<=10; i+=2) { //1,3,5,7,9
			for(int k=1; k <=(9-i)/2; k++){ //앞에 빈칸이 4,3,2,1 출력값은 1,3,5,7,9 
				System.out.print(" ");
			}
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
