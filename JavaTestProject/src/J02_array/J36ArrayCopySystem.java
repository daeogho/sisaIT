package J02_array;

public class J36ArrayCopySystem {

	public static void main(String[] args) {
		// 배열은 생성후 데이터타입이나 배열의 크기를 변경할 수 없다.
		// 배열의 크기가 맞지 않을 경우 배열을 새로 만들어 필요하 데이터 복사하여 사용한다.
		
		int src[] = {10, 90, 30, 70, 80, 100, 50, 110, 40, 130};
		int tar[] = new int[20];
		
		// 1. 원본배열명
		// 2. 원보배열의 복사 시작 위치 인덱스
		// 3. 타겟배열명
		// 4. 타겟배열의 복사 시작 위치 인덱스
		// 5. 복사할 데이터의 갯수
		// arraycopy(Object src, int srcPos, Object dest, int destPos, int length
		System.arraycopy(src, 2, tar, 4, 5);
		
		for(int i = 0; i <tar.length; i++) {
			System.out.println("tar["+i+"]=" + tar[i]);
			
		}

	}

}
