package J02_array;

public class J33Array {

	public static void main(String[] args) {
		// 배열 : 같은 데이터타입의 변수가 많이 필요할때
		// 1차원,2차원,다차원배열이 있다.

		// 배열선언
		// 국어점수 10개를 저장할 수 있는 변수를 선언
		int kor[];
		int[] eng;
		// 배열은 한번 생성하면 크기를 변경할 수 없다.
		int[] mat = new int[10]; // 정수형의 0, 실수형은 0.0, 문자열은 null

		int x;
		int y = 0;

		mat[2] = 5;
		mat[5] = 12;

		// index 8번째 변수에 53을 대입
		mat[8] = 53;
		int sum = 0; // 배열의 크기 : 배열명.length -> 12
		for (int i = 0; i < mat.length; i++) { // 0,1,2,3,4,5,6,7,8,9,10,11
			// 합 sum = sum+값
			sum += mat[i];
			System.out.println("mat[" + i + "]=" + mat[i]);
		}
		// System.out.println( mat[10] );
		System.out.println("합=" + sum);

	}

}
