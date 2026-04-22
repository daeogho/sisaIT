package J01_basic;

public class J29Break {

	public static void main(String[] args) {
		// break : 반복문을 벗어난다.
		for(int i =1; i<=10; i++) {
			for(int j=1 ; ; j++) {
				System.out.println("i="+i + ", J="+j);
				if(j == 3)
					break;
			}
			break;
			
		}
		 // 라벨생성하여 break위치를 지정 
		A: for(int a=1; a <= 10; a++) {
			// 10번 돌고
			for(int b=1; b <= 10; b++) {
				// 100번 돌고
				for(int c=1; c<=10; c++) {
					// 1000번 돈다
					// a+b+c = sum 합이 10이상이면 반복문 중단
					int sum = a+b+c;
					System.out.printf("%d+%d+%d=%d\n", a,b,c,sum);
					if(sum>=10) {
						break A;
					}
				}
			}
		} // 라벨생성으로 인해 여기서 종료
		System.out.println("===============");

	}

}
