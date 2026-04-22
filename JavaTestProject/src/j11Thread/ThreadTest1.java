package j11Thread;

public class ThreadTest1 {

	public ThreadTest1() {
		
	}
	public void start() {
		sum("one");
		sum("two");
		sum("three");
	}
	public void sum(String msg) {
		int sum = 0;
		for(int i=1; ; i++) {
			sum = sum + i;
			System.out.printf("%s==> 1~%d까지의 합은 %d입니다.\n", msg, i, sum);
		}
		
	}
	public static void main(String[] args) {
		new ThreadTest1().start();

	}

}
