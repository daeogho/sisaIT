package j11Thread;
// Runnable 인터페이스를 상속받아 스레드구현
// 1. Runnable 상속받기
// 2. run()메소드 오버라이딩
// 3. Thread객체 생성
// 4. Thread객체 시작
public class ThreadTest3 implements Runnable{
	String title;
	public ThreadTest3() {}
	public ThreadTest3(String title){
		this.title = title;
		
	}
	@Override
	public void run() {
		for(int i =1; ; i++) {
			System.out.println(title + "===>" + i);
			
			// 잠재우기
			try {
			Thread.sleep(500);
			}catch(InterruptedException ie) {
				
			}
			
		}
	}

	public static void main(String[] args) {
		ThreadTest3 tt1 = new ThreadTest3("one");
		ThreadTest3 tt2 = new ThreadTest3("two");
		ThreadTest3 tt3 = new ThreadTest3("three");
		
		// 스레드 시작하는 start()메소드가 Thread클래스의 메소드이므로
		// 스레드 객체를 생성하여 실행해야 한다.
		Thread t1 = new Thread(tt1);
		Thread t2 = new Thread(tt2);
		Thread t3 = new Thread(tt3);
		
		t1.start();
		t2.start();
		t3.start();
	}

}
