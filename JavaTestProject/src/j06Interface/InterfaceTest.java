package j06Interface;

// 클래스명 왼쪽에 interface로 기술한다.
// static final 변수
// 추상메소드를 기술한다.
// 인터페이스에서 인터페이스를 상속받을 때는 extends키워드를 이용하고 1개의 interface만 상속받을 수 있다.
public interface InterfaceTest extends InterfaceB{
	public static final int MAX = 1000;
	public static final String Dong = "강남동";
	
	public void plus(int a, int b);
	public void minus(int x, int y);
	
	public void multiple(int a, int b);

}
