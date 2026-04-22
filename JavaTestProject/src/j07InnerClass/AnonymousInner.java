package j07InnerClass;

public class AnonymousInner {

	public AnonymousInner() {}
	
	public void start() {
		//익명의 내부 클래스		
		
		String result = new Employee() {
			// 변수
			int sal = 2000;
			// 메소드
			void method() {
				System.out.println(sal);
			}
			// 오버라이딩
			// Employee의 public 메소드 접근가능
			@Override
			public String toString() {
				return "사원번호:" + getEmpNo() + ", 사원명:" + getEmpName() + ", 직급=" + getPosition();
			}
			// 익명의 내부 클래스는 클래스명이 없으므로 객체를 생성할 수 없다.
			// 익명의 내부 클래스를 생성 후 .메소드명() 으로 호출하여 실행한다.
		}.toString();    //.method();
	
		System.out.println(result);
	}
	public static void main(String[] args) {
		new AnonymousInner().start();
	}

}
