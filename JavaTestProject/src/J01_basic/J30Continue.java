package J01_basic;

public class J30Continue {

	public static void main(String[] args) {
		// continue : 반복내의 실행문을 건너뛰기한다.
		for (int i = 1; i <= 100; i++) { // i=1,2,3,4,5.... 1씩 증가 100이 될 때까지

			if (i % 3 == 0) { // 3의 배수 인것만 나오게 하기
				System.out.println("i=" + i);
			}
			
		}

	}

}
