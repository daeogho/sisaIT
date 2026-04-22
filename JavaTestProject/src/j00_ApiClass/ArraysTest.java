package j00_ApiClass;

import java.util.Arrays;

public class ArraysTest {

	public static void main(String[] args) {
		// Arrays클래스는 배열처리를 하는 클래스이다.
		//           0   1   2   3   4   5  6   7
		int src[] = {25, 87, 4, 95, 62, 78, 63, 55};
		
		//배열의 복사 : copyOfRange
		//                                 시작index 끝index앞 위치 값까지
		int copy[] = Arrays.copyOfRange(src,   2,      5);
		for(int i=0; i<copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		System.out.println();
//---------------------------------------------------------------------------------
		
		// toString() : 배열의 값을 [25, 87, 4, .......] 만들어 준다. src 배열의 값 출력
		String srcString = Arrays.toString(src);
		//System.out.println("0" + srcString);
//---------------------------------------------------------------------------------		
		
//		Arrays.fill(src, 3, 6, 100); // index 3에서 6앞까지의 값을 100변경
//		srcString = Arrays.toString(src);
//		System.out.println("1"+srcString);
//---------------------------------------------------------------------------------
		
		//정렬하기
		Arrays.sort(src);
		System.out.println(Arrays.toString(src)); // 오름차순으로 정렬
		
		int index = Arrays.binarySearch(src, 4); //배열이 정열이 되어 있어야 한다.
		System.out.println("index=" + index);
		
	}

}
