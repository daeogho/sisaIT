package J01_basic;

public class J17For {

	public static void main(String[] args) {
		// 반복문을 이용하여 합을 구하기
		// 1~100까지의 합은 : 5050
		
		int sum=0;
		int i = 1;
		for(i = 3; i<=100; i+=3) {// i=1,2,3,4.....10
			sum = sum + i; //sum += i;
			System.out.println("1~"+ i +"까지의 합은 "+sum);
		}
		//System.out.println("sum="+sum);
		// 1~100까지의 합은 5050
		//System.out.println("1~"+(i-1)+"까지의 합은 "+sum);

	}

}
