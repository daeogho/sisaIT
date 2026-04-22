package J01_basic;

public class J21For {

	public static void main(String[] args) {
		// 
		//for (int = i; i<=1000; i++) {
		//for(int i = 1; ; i++) { //무한루프
		//for(int i = 1; ; ) { // 무한루프
		
		int i = 1;
		//for( ; i<=100 ; ) { //무한루프
		for( ; ; ) {
			System.out.println(i++);
			if(i>100) {
				break;//반복문 중단
			}
			
			
		}
		// --> break를 만나면 for문 다음으로 실행이 이동

	}

}
