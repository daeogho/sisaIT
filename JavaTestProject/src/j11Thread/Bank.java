package j11Thread;

public class Bank implements Runnable {

	private int money = 10000; // 잔고

	public Bank() {
		// 스레드 메소드 오버라이딩
	}

	public void run() {
		// 현재 실행중인 스레드 처리가 끝날때까지
		// 다음 스레드를 대기시킨다.
		// 스레드 동기화
		synchronized (this) {

			// 한번에 1000원씩 10번 출금.
			for (int i = 1; i <= 10; i++) {
				getCash(1000); // 출금

				// 잔액이 2000배수일때 스레드를 일시정지하기
				if (money % 2000 == 0) {
					try {
						this.wait(); // 일시정지
					} catch (InterruptedException ie) {
						System.out.println(ie.getMessage());
					}
				} else {
					this.notify(); // 일시정지 한 것을 동기화하기
				}
			}
		}

	}

	// 출금 메소드
	public void getCash(int cash) {
		// 현재 어떤스레드가 실행중인지 이름을 얻어오기
		String threadName = Thread.currentThread().getName();
		if (money >= cash) { // 잔고 확인
			money = money - cash;
			System.out.println(threadName + "-->잔액=" + money + "원");
		} else { // 잔액이 부족하면
			System.out.println(threadName + "-->잔액이 부족합니다.");
		}
	}

	public static void main(String[] args) {
		Bank bank = new Bank();

		Thread mother = new Thread(bank, "엄마");
		Thread sun = new Thread(bank, "아들");

		mother.start();
		sun.start();
	}

}
