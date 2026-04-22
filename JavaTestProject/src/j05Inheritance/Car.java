package j05Inheritance;

public class Car {
	// 멤버변수
	int speed = 0;
	String color = "white";
	int max = 150;//최대속도
	String brend = "소나타";
	// 생성자메소드
	public Car() {
		System.out.println("Car()생성자 실행됨");
	}
	public Car(int speed, String brend, String color) {
		this.speed = speed;
		this.brend = brend;
		this.color = color;
		System.out.println("Car(int speed, String brand, color)생성자 메소드 실행됨");
	}
	// 메소드 - excel
	public void speedUp() {
		speed +=2;
				if(speed >= max) 
					speed = max;					
				}
	public void speedDown() {
			speed -=2;
			if(speed < 0) {
				speed = 0;						
		}
	}
		public String toString() {
			String str = "속도 :  "+speed+", 색상= "+color+", 브랜드="+ brend;
			return str;
		}

}
