package J03_oop;

public class CalculatorMain {

	public static void main(String[] args) {
		Calculator ct = new Calculator();
		
		System.out.println("곱하기 =>" + ct.multiple(5,6));
		
		System.out.println("루트=>" + ct.root(20));
		
		//메소드를 한번 호출 합차곱몫이 처리
		ct.AllCalcu(56, 23);
		
		double result[] = ct.allCalcu2(40, 30);
		
		System.out.println("합=>" + result[0]);
		System.out.println("차=>" + result[1]);
		System.out.println("곱=>" + result[2]);
		System.out.println("몫=>" + result[3]);
		
		System.out.println("합=" + ct.plus(10,20));
	}

}
