package J02_array;

import java.util.Random;

public class ModeNumber {

	public static void main(String[] args) {
		Random random = new Random();
		// 1~100 사이의 난수 1000개 만들어 최빈수 구하기
		
		// 난수를 생성하며 갯수를 구한다.
		// 갯수 구해서 보관할 배열
		int data[] = new int[101]; // 0~100
		// 난수 1000개
		for(int i=0; i<1000; i++) { // 회전할때마다 1,2,3,4,5...
			int ran = random.nextInt(100)+1;
			
			// ran에 있는 값을 index로 사용하고 그 index의 값을 1증가 시킨다.
			data[ran]++; // ++data[ran], data[ran] +=1, data[ran] = data[ran]+1
			
		}
		// 최빈수 구하기
		// 최빈수를 보관할 변수
		int max = 1;
		for(int i=2; i<data.length; i++) { //2,3,4,5....100
			if(data[max] <= data[i]) {
				max =i;
			}
			
		}
		for(int i =1; i<data.length; i++) {
			System.out.println("data["+i+"]=" + data[i]);
		}
		System.out.print("최빈수 =" + max);

	}

}
