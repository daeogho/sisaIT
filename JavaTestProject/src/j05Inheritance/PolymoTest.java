package j05Inheritance;

public class PolymoTest {

	public PolymoTest() {
		// 다향성
		// 하위클래스 객체는 상위 클래스 타입의 변수에 대입할수 있다.
		// Object, AAA, BBB, CCC
		CCC a = new CCC();
		BBB b = new CCC();
		AAA c = new CCC();
		Object d = new CCC();
		
		System.out.println("a.getName()=" + a.getName());
		a.setAge(25); // CCC클래스 age의 값을 25로 변경
		System.out.println("a.age=" + a.age);
		System.out.println("----------------------------");
		
		b.output(); // AAA클래스의 outputMethod() ,A 클래스에 있는것
		System.out.println("b.getName()=" + b.getName()); // 김삿갓, B 클래스에 있는것
		// System.out.println("b.age=" + b.age(); // C클래스에 있는것
		b.msg();
		
		
		// 하위클래스 타입의 객체를 상위 클래스타입에 대입후
		// 다시 하위 클래스로 대입할 때는 강제 형변환하면 된다.
		CCC x = (CCC)b;
		//CCC y = new BBB();
	}

	public static void main(String[] args) {
		new PolymoTest();

	}

}
