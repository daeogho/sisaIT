package j07InnerClass;

public class OuterClass { //외부 클래스
	int num = 1234;
	String name = "홍길동";
	String addr = "서울시 강남구";

	public OuterClass() {
		// TODO Auto-generated constructor stub
	}
	public void print() {
		System.out.println("번호=" +num);
		System.out.println("이름=" +name);
		// 내부클래스를 객체로 만들어 접근은 가능하다
		InnerClass in = new InnerClass();
		System.out.println("전화번호=" + in.tel);
	}	
	public String getName() {
		return name;
	}
	
//----------------------------------------------------------------------
	
	// 클래스 생성 - 내부클래스
	class InnerClass{
		//변수
		int num = 2222;
		String name = "세종대왕";
		String tel = "010-1234-5678";
		//생성자
		InnerClass(){}		
		//메소드
		void output() {
			// 내부클래스 외부클래스의 멤버변수를 접근할 수 있다.
			System.out.println(num+", "+ name + ", " + tel + ", " + addr);
			// 내부클래스에서 외부클래스의 메소드 호출 가능하다.
			print();
			System.out.println(getName());
		}
	}
	
	public static void main(String args[]) {
		OuterClass oc = new OuterClass();
		oc.print();
		
		// 내부 클래스를 객체 생성하는 방법
		// 1. 외부클래스 객체 생성
		// 2. 외부클래스 객체를 이용하여 내부 클래스 객체를 생성한다.
		OuterClass outer = new OuterClass();		
		InnerClass ic1 = outer.new InnerClass();
		ic1.output();
		
		InnerClass ic2 = new OuterClass().new InnerClass();
		ic2.output();
	}
}
