package j00_ApiClass;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		// Random 클래스 테스트
		// 난수 생성
		
		Random random = new Random(); // java.lang패키지는 그냥사용할 수 있다. java.util에 있기 때문에 import하여야 한다.

		//논리형 난수
		for(int i=0; i <=45; i++) {
			// boolean ranBoo = random.nextBoolean(); // 참, 거짓 100개 까지
			//System.out.print(ranBoo + "\t");
			
			//double randouble = random.nextDouble(); // Math.random() 이랑 같다.
			//System.out.print(randouble + "\t");
			
			//int ranint = random.nextInt();
			//System.out.print(ranint + "\t");
			
			int ranInt = random.nextInt(100-50+1) + 50; // 10 => 0~9, 50 -> 0~49, 100 -> 0~99 (마지막에 숫자를 더해주면 그 숫자부터 시작)
			System.out.print(ranInt + "\t");
			
			if( i%7 == 0) {
				System.out.println();
			}
		}
		
	}

}
