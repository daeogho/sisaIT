package J02_array;

public class J34Array {

	public static void main(String[] args) {
		// 초기값이 있는 배열 선언하기

		int arr[] = new int[] { 53, 25, 85, 45, 89 };
		int sum = 0;
		double avg = 0;

		for (int i = 0; i < arr.length; i++) { // i=0,1,2,3,4
			sum += arr[i];
			avg = (double) (sum) / arr.length;
			System.out.println("arr[" + i + "]=" + arr[i]);
		}
		System.out.println("총합 =" + sum);
		System.out.printf("평균 =%.2f\n", avg);

// -------------------------------------------------------------------------------------		
		String[] name = new String[] { "코스모스", "해바라기", "히야신스", "장미", "안개꽃", "개나리" };
		for (int i = 0; i < name.length; i++)
			System.out.println("name[" + i + "]=" + name[i]);
// -------------------------------------------------------------------------------------		

		double data[] = { 12.5, 5.3, 45.2, 78.6 };
		for (int i = 0; i < data.length; i++) {
			System.out.println("data[" + i + "]=" + data[i]);
		}

		boolean arr2[] = new boolean[3]; // 0 1 2
		arr2[1] = true;
		for (int i = 0; i < arr2.length; i++) {
			System.out.print("\narr2[" + i + "]" + arr2[i]);
		}

// -------------------------------------------------------------------------------------		
		int arr3[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// 확장된 for문 : 배열, 컬렉션을 이용하여 반복처리
		// :배열의 데이터타입변수 : 배열명
		int tot = 0;
		for (int a : arr3) {
			tot = tot + a;
			System.out.println(a);
		}
		System.out.println("tot=" + tot);
// -------------------------------------------------------------------------------------
	}

}
