package Practice;

public class J15GuGuDan3 {

	public J15GuGuDan3() {
		// 카페문제 구구단 1줄단 3단 출력하기
		
		System.out.print("\t\t구구단\n");		
		for(int dan=1; dan <=9; dan++) {
			System.out.print("\t=="+dan+"단==");
			
			if(dan%3==0) {
				System.out.println();
				for(int j=2; j<=9; j++) {
					
					for(int i=2; i>=0; i--) {
						int k = dan-i;
						int result = k*j;
						System.out.print("\t"+k+"*"+j+"="+result);
					} System.out.println();
					
				}
			}
		}
			
}


	public static void main(String[] args) {
		new J15GuGuDan3();

	}

}
