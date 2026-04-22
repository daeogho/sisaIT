package J03_oop;

public class ConstractorOverLoading {
	
	int num; //0
	String name; // 초기값이 null
	
	// 오버로딩 : 같은 클래스에 같은 이름을 가진 생성자메소드가 여러개인 경우
	
	public ConstractorOverLoading() {
		num = 100;
		name = "Smith";
		System.out.println("ConstractorOverLoading()생성자 실행됨");
	}
	
	public ConstractorOverLoading(int num) {
		this.num=num;
		System.out.println("ConstractorOverLoading(int num)생성자 실행됨");
	}
	public ConstractorOverLoading(String name) {
		this.name = name;
	}
	public ConstractorOverLoading(int num, String name) {
		// this.num = num;
		// 생성자메소드내에서 다른 생성자를 호출할 때는 this()를 이용하여야 한다.
		// ConstractorOverLoading(num);
		// 반드시 첫번째 실행문이여야 한다.
		// 다른 생성자를 호출하는 this()는 한번만 수행할 수 있다.
		this(num);
		this.name = name;
		//this(name);
		
		
		System.out.println("ConStractorOverLoading(int num, String name)생성자 실행됨");
	}

}
