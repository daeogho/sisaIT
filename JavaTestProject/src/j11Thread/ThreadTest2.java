package j11Thread;

// Thread처리가 되는 클래스 생성규칙
// 1. Thread클래스를 상속받아 run()메소드를 오버라이딩하여 구현한다.
// 2. Runnable인터페이스 상속받아 스레드 처리하기
public class ThreadTest2 extends Thread{
	String msg;
	public ThreadTest2() {
		
	}
	public ThreadTest2(String msg) {
		this.msg=msg;
	}
	@Override
	public void run() {
		// 스레드 처리를 할 명령어를 구현한다.
		int sum = 0;
		for(int i =1; ; i++) {
			sum += i;
			System.out.println(msg + "==>1~" + i + "까지의 합은" + sum + "이다.~~~");
		}
	}
	

	public static void main(String[] args) {
		ThreadTest2 t1 = new ThreadTest2("첫번째 스레드");
		ThreadTest2 t2 = new ThreadTest2("두번째 스레드");
		ThreadTest2 t3 = new ThreadTest2("세번째 스레드");
		
		// 스레드는 start()메소드 호출하면 JVM의 스레드 스케쥴러가 
		// 스레드 처리를 해준다.
		t1.start();
		t2.start();
		t3.start();

	}

}
