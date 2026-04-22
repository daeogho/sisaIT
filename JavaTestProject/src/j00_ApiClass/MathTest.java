package j00_ApiClass;

public class MathTest {

	public static void main(String[] args) {
		// Math : 수학관련 기능들을 만들어 놓은 클래스
		// Math.abs()
		
		// 절대값 구하기 -5->5, 5->5
		System.out.println("절대값(abs)=>"+ Math.abs(-10));
		
		//반올림
		System.out.println("반올림(round)=>"+ Math.round(30));
		//올림 4.1 -> 5, 4.9-> 5
		System.out.println("올림(ceil)=>"+ Math.ceil(4.1));
		//버림 8.2 -> 8, 8.9->8
		System.out.println("버림(floor)=>" + Math.floor(5.6));
		
		//큰값
		System.out.println("큰값(max)=>"+ Math.max(78,92));
		//작은값
		System.out.println("작은값(min)=>" + Math.min(54,30));		
		//거듭제곱
		System.out.println("거듭제곱(pow)=>"+ Math.pow(5, 3));
		
		//루트
		System.out.println("루트(sqrt)=>"+ Math.sqrt(10));
//---------------------------------------------------------------------------
		
		//난수
		// 0.0000000001 ~ 0.99999999999 사이의 값이 생성
		System.out.println("===이번주 로또 번호는?===");
		for(int i =1; i<=100; i++) {
			double random = Math.random();
			
			int ranInt = (int)(random*46);
			//int ranInt = (int)(r
			//andom * (87-39+1)) + 39; //39~87사이의 값이 나오도록 하는것
			
			// 난수 *11 = 0~10 
						// *100 -> 0~99 , *45-> 0~44, *72 -> ~71
						//----------------------------------------
						// 5~15 (난수*(큰수-작은수+1))+작은수
						//   ex) (난수*(15-5+1))+5
						//     
						//       +작은값 = 5~15
			
			System.out.printf("%d\t",ranInt);
//---------------------------------------------------------------------			
			if(i%7 == 0) { //7칸이 되었을때 
				System.out.println(); // 줄을 바꾼다.
			}
			
			
		}

	}

}
