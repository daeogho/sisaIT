package Practice;

public class J09MathPractice {

	public static void main(String[] args) {
		// 카페문제
		/* 1~100까지의 난수를 1000개 만들어 배열에 저장
		 * 총합과 평균구하기
		 * 
		 */
		int num[] = new int[1000];
		
		for(int i = 0; i < num.length; i++) { // 범위 잘 정하기 
			num[i] = (int)(Math.random()*(100))+1;
			
		}
		int total=0;
		int avg=0;
			
		for (int number : num ) {
			total = total+number;
			avg = total / num.length;
		}
		
		System.out.println("총합 =" + total);
		System.out.println("평균 =" + avg);

	}

}
