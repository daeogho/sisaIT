package J03_oop;

public class StaticTest {
	int data = 5500;
	// static : 정적
	// 변수 static 데이터형 왼쪽에 기술한다.
	// static변수는 객체를 생성하더라도 1개밖에 없다.
	static int productCode = 12345;
	
	public StaticTest() {}
	// 메소드에 Static이 있을 때
	// 반환형 왼쪽에 표기한다.
		public static void output(int num, String addr) {
			System.out.println("번호= " + num); //5
			System.out.println("주소= " + addr); // 강남구 삼성동
			//System.out.println("data=" + data); // 5500
			System.out.println("productCode= " + productCode); //5678
	}

}
