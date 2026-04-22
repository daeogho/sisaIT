package J03_oop;

public class FinalTest {
	public int num = 123;
	// Final 은 한번 생성되면 변경할 수 없다.
	// 클래스 : 상속불가
	// 멤버변수 : 값변경 불가
	// 메소드 : 오버라디이 불가
	// 기술가능
	
	// final 멤버변수 : 변수명을 모두 대문자로 만들자
	//                합성어일때는 _로 구별한다
	// Math.PI
	final int DATA = 1000; //초기값
	static final int AGE = 30; // 초기값 없다.
	String addr = "서울시 강남구";
	public FinalTest() { // 초기값이 없으면 에러가 뜬다.
		num = 456;
	}
	
	public void setNum() {
		num = 112;
		// DATA = 2000; // final 변수이므로 값을 변경할 수 없다.
	}

	public static void main(String[] args) {
		FinalTest ft = new FinalTest(); // 객체를 만들어 주면 num을 사용할 수 있다. 클래스를 따로 만들기 귀찮기에 한번에 사용할 수 있도록 해준다.
		ft.num = 333; // 특수한 메소드이기 때문에 다른 공간에 있다고 이해하면 된다.
		
		System.out.println(ft.DATA);
		System.out.println(FinalTest.AGE);

	}

}
