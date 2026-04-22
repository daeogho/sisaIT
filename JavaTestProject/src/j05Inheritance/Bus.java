package j05Inheritance;

// 클래스에서 다른 클래스를 상속을 받기 위해서는 extends 키워드 이용한다.
// 상속은 클래스 1개만 상속할 수 있다.
public class Bus extends Car{
	int speed = 50;
	String color = "green";
	public Bus() {
		// 상위 클래스 원하는 생성자 메소드를 호출해주면 된다.
		super(20, "그렌저", "블랙");
		System.out.println("Bus()생성자 실행됨");		
	}
	// 메소드 오버라이딩
	// 상속관계에서만 기술되고 상위클래스의 메소드명과 메개변수 갯수와 데이터형이 같은 메소드를 재정의 하는것을 말한다.
	// 접근제어자는 상위클래스의 접근제어자보다 범위 넓은 접근제어자 표시할수 있다.
	// public > protected > default > private
	@Override // annotation
	public void speedUp() {
		super.speed +=10;
		if(super.speed >=max) {
			super.speed = 150;
			max = 200;
			// this max = 200;
			// super.max = 200;
		}
	}
	public void setColor(String color) {
		//super : 상위 클래스
		super.color = color;
		super.speedUp();
	}
	public void output() {
		System.out.println("Bus.speed=" + speed +", Bus.color=" + color);
	}
	public static void main(String arg[]) {
		Bus bus = new Bus();
		
		bus.speedUp();		
		bus.setColor("red");
		
		System.out.println(bus.toString());
		bus.output();
		
	}

}
