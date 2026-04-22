package Practice;

public class J01Practice {

	public static void main(String[] args) {
		// 3장 실습 문제 1
		
		int pay = 80;
		double bonus = (pay<100)? pay*0.2 : pay*0.1;
		System.out.println("급여->" + pay + "\n보너스->" + (int)bonus);
		
		// 3장 실습 문제2
		int num = 36;
		int size = 10;
		double size2 = size;
		System.out.println(num/size + "," + num/size2);
		
		int num2 = (num/size==num/size2)? num/size : num/size + 1;
		System.out.println("과일갯수="+ num + "\n바구니크기=" + size +
				"\n바구니수=" + num2);
		
		

	}

}
