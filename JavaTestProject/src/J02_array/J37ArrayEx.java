package J02_array;

public class J37ArrayEx {

	public static void main(String[] args) {
		// 카페문제 배열과 난수문제
		
		// 1~100까지의 난수를 1000개 만들어 배열에 저장
		// 총합과 평균 구하기
		
		// Math.random{}
		
		// 1000개의 난수를 보관할 배열형 변수
		int number[] = new int[1000]; //연속공간에 40byte 크기의 변수 1000개 생성
		
		for(int idx =0; idx<number.length; idx++) {
			number[idx] = (int)(Math.random()*(100-1+1))+1; // 1~100까지의 변수 랜덤
		}
//--------------------------------------------------------------------------
		
		//합과 평균을 저장할 변수 선언
		int total = 0;
		int avg = 0;
		
		//확장된 for문
		for( int num : number) {
			total += num;			
		}
		avg = total / number.length;
		System.out.println("합계=" + total);
		System.out.println("평균=" + avg);

	}

}
