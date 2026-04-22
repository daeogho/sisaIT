package j05Inheritance;

// 추상 클래스는 일반메소드와 추상 메소드가 함께 있는 클래스이다.
public abstract class AbstractTest {
	public AbstractTest() {		
	}
	// 메소드
	public void plus(int a, int b) {
		System.out.println(a + " + " + b + "=" + (a+b));
	}
	public void minus(int a, int b) {
		System.out.println(a + "+" + b + "=" + (a-b));
		
	}
	// 추상메소드는 메소드명과 메개변수만 정의하고 실행부를 구현하지 않는 메소드
	// 추상메소드 : 변환형 왼쪽에 abstract 키워드를 표시해야한다.
	public abstract void multiple(int a, int b);
	public abstract void divide(int a, int b);

}
