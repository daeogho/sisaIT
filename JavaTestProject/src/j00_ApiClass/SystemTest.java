package j00_ApiClass;

public class SystemTest {

	public static void main(String[] args) {
		System.out.println("System클래스는 콘솔에 데이터를 출력 또는 입력 할 수 있는 클래스");
		
		// 프로그램을 원하는 위치에서 종료할 수 있다.
		//System.exit(0); //0: 정상종료
		
		System.out.println("기본 API에 있는 클래스이며 콘솔에 텍스트를 출력한다.");
		
		// 현재 시스템의 날짜와 시간 정보를 얻을 수 있다.
		System.out.println("현재시간(millis)->" + System.currentTimeMillis());
		
		// println() : 1줄 출력하는 메소드 : 
		// 제어문자 : \n -> newline, \t -> tabkey(8칸이동), \", \'
		// char c ='A';
		
		// 콘솔에 -> System클래스의 "println" 메소드를 테스트중이다.
		System.out.println("System클래스의 \"println\" 메소드를 \'테스트중\'이다.");
		
		// println() : 출력 후 줄을 바꾸지 않는다.
		System.out.print(1);
		System.out.print(2);
		System.out.println(3);
		
		// printf() : 출력, 원하는 크기 출력범위를 지정할 수 있다.
		int num = 92; //8자리에 출력
		double tot = 89.27; // 총 8자리에 소수이하 1자리만 출력
		
		System.out.printf("국어=%-8d ,영어=%-8.1f\n", num, tot);
		System.out.printf("%3d %8.1f\n", 12345, tot);

		String name = "홍길동";
		String tel = "010-1234-5678";
		
		System.out.printf("%8s,%20s\n", name, tel);
		System.out.printf("%-8s,%-20s\n", name, tel);
		
		System.out.printf("8진수=%o, 16진수=%x\n", 12, 12);
		
		System.out.printf("%d,%f\n", 25685, 352.5584);
		
	}

}
