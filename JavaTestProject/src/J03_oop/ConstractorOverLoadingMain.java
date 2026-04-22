package J03_oop;

public class ConstractorOverLoadingMain {

	public static void main(String[] args) {
		
		ConstractorOverLoading co1 = new ConstractorOverLoading();
		System.out.printf("num=%d, name=%s\n", co1.num, co1.name);
		
		ConstractorOverLoading co2 = new ConstractorOverLoading(200);
		System.out.printf("num=%d, name=%s\n", co2.num, co2.name);
		
		ConstractorOverLoading co3 = new ConstractorOverLoading(300, "홍길동");
		System.out.printf("num=%d, name=%s\n", co3.num, co3.name);

	}

}