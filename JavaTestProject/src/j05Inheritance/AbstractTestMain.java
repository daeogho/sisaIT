package j05Inheritance;

public class AbstractTestMain extends AbstractTest{

	public AbstractTestMain() {
		testStart();
	}
	public void testStart() {
		// 추상메소드는 객체생성할 수 없다.
		// 추상클래스를 상속하여 메소드를 오버라이딩하여야 한다.
		// AbstractTest at = new AbstractTest();
		
		plus (12,20);
		minus(30,20);
		multiple(3,4);
		divide(7,2);
	}
	// 상위 클래스에 있는 추상메소드 오버라이딩
	@Override
	public void multiple(int a, int b) {
		int result = a * b;
		System.out.println("a+b=" + result);
	}
	@Override
	public void divide(int x, int y) {
		int result = x / y;
		System.out.println("a/b=" + result);
	}
	public static void main(String[] args) {
		new AbstractTestMain();

	}

}
