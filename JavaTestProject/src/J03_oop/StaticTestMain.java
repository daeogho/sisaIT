package J03_oop;

public class StaticTestMain {

	public static void main(String[] args) {
		StaticTest st = new StaticTest();
		System.out.println(st.data);
		
		StaticTest st2 = new StaticTest();
		
		st.productCode = 5678;
		
		System.out.println("st => " + st.productCode); // 이렇게 사용하는건 권장하지 않음
		System.out.println("st2 => " + st2.productCode); // 이렇게 사용하는건 권장하지 않음
		System.out.println("staticTest => " + StaticTest.productCode); // 권장
		
		// st2.output(5, "강남구 삼성동");
		StaticTest.output(89, "송파구 잠실동"); // 클래스의 데이터가 없으면 객체도 사용이 안된다.
	}
}
