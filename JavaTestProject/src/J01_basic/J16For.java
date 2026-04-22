package J01_basic;

public class J16For {

	public static void main(String[] args) {
		// 반복분 - for문
		/*
		 * 		for(초기값 ; 최종값(조건식); 증감식){
		 *  		실행문;
		 * 			실행문;
		 * }
		 * 
		 * 1
		 * 2
		 * 3
		 * 4
		 * 5
		 * 
		 */
		// 초기값 조건식이 참일때 반복문이 실행문
		//                  i++, ++i, i=i+i, i+=1 다같은 의미
		for(int i = 1 ; i<=5 ; i++) {
			//출력문
			System.out.println(i);

		}
		//반복문의 조건식이 false일때...
		
		for(int j=5; j>=1 ; j--) {
			System.out.println(j);
		}
		System.out.println("============================");
		
		//짝수 : 1~10까지의 짝수
		for(int i=2; i<=10; i+=2) {
			System.out.println(i);
		}
		//홀수 : 1,3,5,7,9
		for(int j=1; j<=10; j=j+2) {
			System.out.println(j);
		}
	}

		
}
